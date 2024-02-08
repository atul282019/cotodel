package com.cotodel.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cotodel.properties.ApplicationConstantConfig;
import com.cotodel.response.UserDetailsEntity;
import com.cotodel.response.UserForm;
import com.cotodel.response.UserRegistrationRequest;
import com.cotodel.service.LoginService;
import com.cotodel.util.JwtTokenValidator;
import com.cotodel.util.MessageConstant;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@CrossOrigin
public class LoginController extends CotoDelBaseController{

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	public ApplicationConstantConfig applicationConstantConfig;

	@Autowired
	LoginService loginservice;

	@GetMapping(value="/index")
	public ModelAndView firstPage(Model model) {
		logger.info("opening firstPage");
		return new ModelAndView("index", "command", "");
	}	

	@GetMapping(value="/login")
	public ModelAndView loginPage(Model model) {
		logger.info("opening loginPage");
		return new ModelAndView("login", "command", "");
	}	

	@GetMapping(value="/signup")
	public ModelAndView SignupPage(Model model) {
		logger.info("opening signupPage");
		return new ModelAndView("signup", "command", "");
	}	
	@GetMapping(value="/companyDetails")
	public ModelAndView companyDetail(Model model) {
		logger.info("opening companyDetailPage");
		return new ModelAndView("company-details", "command", "");
	}	
	@GetMapping(value="/dashboard")
	public ModelAndView dashboard(Model model) {
		logger.info("opening dashboardPage");
		return new ModelAndView("dashboard", "command", "");
	}
	@GetMapping(value="/dashboard1")
	public String dashboard1(Model model) {
		logger.info("opening dashboardPage");
		String token = (String) session.getAttribute("name");
		if(token!=null && token!="") {
			return "dashboard01";
		}
		return "redirect:/index";
		
	}
	@GetMapping(value="/companyDetails01")
	public ModelAndView companyDetails(Model model) {
		logger.info("opening dashboard-details01");
		return new ModelAndView("company-details01", "command", "");
	}
	

	@PostMapping(value="/smsOtpSender")
	public @ResponseBody String sendOtp(HttpServletRequest request,@ModelAttribute("userForm") UserForm userForm,Locale locale,Model model) {
		ObjectMapper mapper = new ObjectMapper();
		String res=null;String userRes=null;
		HashMap<String, String> otpMap = new  HashMap<String, String> ();
		try {
			userRes=loginservice.sendOtp(userForm.getUserName(),userForm.getMob());
			if(!ObjectUtils.isEmpty(userRes)) {	
				JSONObject userJson= new JSONObject(userRes);
				if(userJson.getString("status")!=null &&  userJson.getString("status").equalsIgnoreCase(MessageConstant.RESPONSE_SUCCESS)) {
					otpMap.put("msg", userJson.getString("message"));
					otpMap.put("status", MessageConstant.RESPONSE_SUCCESS);
				}else {
					otpMap.put("msg", userJson.getString("message"));
					otpMap.put("status", MessageConstant.RESPONSE_FAILED);
				}
			}else { 
				otpMap.put("msg", "System not responding, Please try again later..!"); 
				otpMap.put("status",  MessageConstant.RESPONSE_FAILED); 
			}
			res = mapper.writeValueAsString(otpMap);
			logger.info("response for smsOtpSender *****-----"+res);
		} catch (Exception e) {
			logger.error("error in smsOtpSender =============="+e);
		}finally {
			mapper=null;otpMap=null;userRes=null;
		}
		return res;
	}	
	
	
	@PostMapping(value="/userLogin")
	public String validateLogin(HttpServletResponse response, HttpServletRequest request,
			@ModelAttribute("userForm") UserForm userForm, BindingResult result, HttpSession session, Model model,RedirectAttributes redirect) {
		String profileRes=null;JSONObject profileJsonRes=null;String screenName="index";
		UserDetailsEntity obj =null;
		try {
			String password = null;
			password= userForm.getPassword1()+userForm.getPassword2()+userForm.getPassword3()+userForm.getPassword4()+userForm.getPassword5()+userForm.getPassword6();      
			profileRes =loginservice.verifyOtp(userForm.getUserName(),userForm.getMob(),password );
			
			logger.info(profileRes);
			
			if(!ObjectUtils.isEmpty(profileRes)) {
				
				profileJsonRes= new JSONObject(profileRes);
				
				if(profileJsonRes.getString("status")!=null 
						&& profileJsonRes.getString("status").equalsIgnoreCase(MessageConstant.RESPONSE_SUCCESS)) {
				
					//set token in session
					request.getSession(true).setAttribute("name", profileJsonRes.getJSONObject("data").getString("username"));									  
					request.getSession(true).setAttribute("cotodel", profileJsonRes.getString("token"));
					
					obj =  JwtTokenValidator.parseToken(profileJsonRes.getString("token"));
				
					// switch case to identify the user screen login
					switch (String.valueOf(profileJsonRes.getJSONObject("data").getInt("role"))) {	
					case "1":
						screenName="index";
						model.addAttribute("message", "No Role assigned to User. Please contact to Organisation Admin !!");
						break;		
					case "0":
						screenName="dashboard";
						model.addAttribute("name",profileJsonRes.getJSONObject("data").getString("username"));
						break;		
					}
					return screenName;
				}else {
						model.addAttribute("message", "Incorrect OTP !!");
				}
			}else {
				model.addAttribute("message", "Incorrect OTP !!");
			}	
			return "index";
		}catch (Exception e) {
			logger.error(e.getMessage());
			model.addAttribute("message", "System not responding, Please try again later..!");
			return "index";
		}finally {
			profileRes=null;profileJsonRes=null;screenName=null; obj =null;
		}
	}
	
	@PostMapping(value="/registerUser")
	public @ResponseBody String registerUser(HttpServletRequest request,UserRegistrationRequest userForm) {
		String profileRes=null;JSONObject profileJsonRes=null;
		logger.info("opening getInTouch");
		profileRes = loginservice.registerUser(userForm);
		profileJsonRes= new JSONObject(profileRes);
		
		if(profileJsonRes.getString("status")!=null && profileJsonRes.getString("status").equalsIgnoreCase("SUCCESS")) { 
		loginservice.sendEmailToEmployee(userForm);
		}
		return profileRes;
	}
	
	@RequestMapping(value = "/confirm/{token}/{emailbyt}", method = RequestMethod.GET)
	public ModelAndView getRegistrationVerifiction(Model model, HttpServletRequest request, @PathVariable("token") String token
			,@PathVariable("emailbyt") String emailbyt) {
		
			System.out.println("In Request Mapping"); 
			byte[] tokenBytes = Base64.getDecoder().decode(token);//parseBase64Binary(token + "==");
			String mobileno = new String(tokenBytes, StandardCharsets.UTF_8);
			byte[] emailBytes = Base64.getDecoder().decode(emailbyt);
			String emailAgain = new String(emailBytes, StandardCharsets.UTF_8);
			System.out.println(mobileno + " ------ "+emailAgain);
			
		    UserRegistrationRequest userForm = new UserRegistrationRequest();
			userForm.setEmail(mobileno);
			userForm.setMobile(mobileno);
			model.addAttribute("userform",userForm);
		
			return new ModelAndView("emailverification", "command", "");
		
	}
	
	
	
	@PostMapping(value="/verifyRegisterUser")
	public @ResponseBody String verifyRegisterUser(HttpServletRequest request,UserRegistrationRequest userForm) {
		String profileRes=null;JSONObject profileJsonRes=null;
		HashMap<String, String> otpMap = new  HashMap<String, String> ();
		ObjectMapper mapper = new ObjectMapper();
		String res=null;String userRes=null;
		profileRes = loginservice.verifyRegisterUser(userForm);
		profileJsonRes= new JSONObject(profileRes);
		
		if(profileJsonRes.getString("status")!=null && profileJsonRes.getString("status").equalsIgnoreCase("SUCCESS")) { 
			loginservice.sendEmailVerificationCompletion(userForm);
			otpMap.put("status", MessageConstant.RESPONSE_SUCCESS);
		}else {
			loginservice.sendEmailVerificationCompletion(userForm);
			otpMap.put("status", MessageConstant.RESPONSE_FAILED);
		}
		try {
			res = mapper.writeValueAsString(otpMap);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return profileRes;
	}
}