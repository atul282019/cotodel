package com.cotodel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cotodel.response.UserDetailsEntity;
import com.cotodel.util.JwtTokenValidator;
@Controller
@CrossOrigin
public class StaticPageController extends CotoDelBaseController{

	private static final Logger logger = LoggerFactory.getLogger(StaticPageController.class);
	
	@GetMapping(value="/index")
	public ModelAndView firstPage(Model model) {
		logger.info("opening firstPage");
		return new ModelAndView("index", "command", "");
	}	

	@GetMapping(value="/test")
	public ModelAndView testMethod(Model model) {
		logger.info("opening firstPage");
		return new ModelAndView("test", "command", "");
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
	public String companyDetail(Model model) {
		logger.info("opening companyDetailPage");
		String token = (String) session.getAttribute("cotodel");
		if(token!=null) {
//			UserDetailsEntity obj = JwtTokenValidator.parseToken(token);
//			if(obj!=null) {
//				model.addAttribute("name",obj.getName());
//				model.addAttribute("org",obj.getOrgName());
//				model.addAttribute("mobile",obj.getMobile());
//				model.addAttribute("email",obj.getEmail());
//				return "company-details";
//			}
			return "company-details";
		}
		return "redirect:/index";
	}	
	@GetMapping(value="/dashboard")
	public String dashboard(Model model) {
		logger.info("opening dashboardPage");
		String token = (String) session.getAttribute("cotodel");
		if(token!=null) {
			UserDetailsEntity obj = JwtTokenValidator.parseToken(token);
//			if(obj!=null) {
//				model.addAttribute("name",obj.getName());
//				model.addAttribute("org",obj.getOrgName());
//				model.addAttribute("mobile",obj.getMobile());
//				model.addAttribute("email",obj.getEmail());
//				return "dashboard";
//			}
			return "dashboard";
		}
		return "redirect:/index";
		
	}
	@GetMapping(value="/dashboard1")
	public String dashboard1(Model model) {
		logger.info("opening dashboardPage");
		String token = (String) session.getAttribute("cotodel");
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
	
}
