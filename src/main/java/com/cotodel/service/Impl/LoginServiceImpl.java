package com.cotodel.service.Impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotodel.properties.ApplicationConstantConfig;
import com.cotodel.response.UserForm;
import com.cotodel.response.UserRegistrationRequest;
import com.cotodel.service.LoginService;
import com.cotodel.util.CommonUtility;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Properties;
import javax.xml.bind.DatatypeConverter;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	public ApplicationConstantConfig applicationConstantConfig;
	
	//private static final Logger logger = LogManager.getLogger(LoginServiceImpl.class);
	
	@Override
	public String sendOtp(String userName, String mobile) {	
		return CommonUtility.userRequest(null,sendOtpRequest(mobile), applicationConstantConfig.GET_OTP);
	}
	
	public static String sendOtpRequest(String mobile) {
		JSONObject request= new JSONObject();
		request.put("mobile", mobile);	
		return request.toString();
	}
	
	@Override
	public String verifyOtp(String userName, String mob, String otp) {
		return CommonUtility.userRequest(null,verifyOtpOrLoginRequest(mob,otp), applicationConstantConfig.VERFY_OTP);
	}
	
	
	public static String verifyOtpOrLoginRequest(String mobile,String otp) {
		JSONObject request= new JSONObject();
		request.put("mobile", mobile);	
		request.put("otp", otp);	
		return request.toString();
	}

	@Override
	public String registerUser(UserRegistrationRequest req) {
		return CommonUtility.userRequest(null,registerUserRequest(req), applicationConstantConfig.REGISTER_USER);
	}
	
	public static String registerUserRequest(UserRegistrationRequest req) {
		JSONObject request= new JSONObject();
		request.put("email", req.getEmail());	
		request.put("orgname", req.getOrgname());	
		request.put("mobile", req.getMobile());	
		request.put("name", req.getUsername());	
		return request.toString();
	}


	@Override
	public void sendEmailToEmployee(UserRegistrationRequest req) {
		
		 // Set up mail server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
		  Session session = Session.getInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("dkawal73@gmail.com", "jaygeajbqvinwacz");
	            }
	        });
			
			Message msg = new MimeMessage(session);
				try {
					msg.setHeader("Content-Type", "text/plain; charset=UTF-8");
					msg.setFrom(new InternetAddress(req.getEmail(), false));
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(req.getEmail()));
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("atulyadavmca@gmail.com"));
					msg.setSubject("User Registration Request Verification");
					msg.setContent("Verify Sigin", "text/html");
					msg.setSentDate(new Date());
					byte[] bytes = req.getMobile().getBytes(StandardCharsets.UTF_8);
				    String encoded = DatatypeConverter.printBase64Binary(bytes);
				    byte[] byt = req.getEmail().getBytes(StandardCharsets.UTF_8);
				    String emailbyt = DatatypeConverter.printBase64Binary(byt);
				    
				    String confirmationUrl = "http://localhost:9191/cotodel/confirm?token="+encoded.replaceAll("==","")+"/"+emailbyt;
				    String emailBody = "Click the link to verify your email: " + confirmationUrl;
				    
					String link="<p></p><a href=" +"http://localhost:9191/cotodel/confirm/"+emailbyt.replaceAll("==","")+"/"+encoded.replaceAll("==","") +"><h3>Please click here to verify....<h3></a>";
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					//String password =generatePassword(8);
					messageBodyPart.setContent(link, "text/html");
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart);
//					MimeBodyPart attachPart = new MimeBodyPart();
//					attachPart.attachFile(attachement);
//					multipart.addBodyPart(attachPart);
					msg.setContent(multipart);
					Transport.send(msg);
					System.out.println("verification mail sended successfully to :"+req.getEmail());

				} catch (MessagingException e) {
					e.printStackTrace();
				}
			
			}
	
	@Override
	public void sendEmailVerificationCompletion(UserRegistrationRequest req) {
		
		 // Set up mail server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
		  Session session = Session.getInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("dkawal73@gmail.com", "jaygeajbqvinwacz");
	            }
	        });
			
			Message msg = new MimeMessage(session);
				try {
					msg.setHeader("Content-Type", "text/plain; charset=UTF-8");
					msg.setFrom(new InternetAddress(req.getMobile(), false));
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(req.getMobile()));
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("atulyadavmca@gmail.com"));
					msg.setSubject("Verification Success");
					msg.setContent("Verify Sigin", "text/html");
					msg.setSentDate(new Date());
					//byte[] bytes = req.getMobile().getBytes(StandardCharsets.UTF_8);
				   // String encoded = DatatypeConverter.printBase64Binary(bytes);
				    //byte[] byt = req.getEmail().getBytes(StandardCharsets.UTF_8);
				   // String emailbyt = DatatypeConverter.printBase64Binary(byt);
				    
					String link="<h3>Email Verification Successfully Completed now you can sign in....<h3>";
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setContent(link, "text/html");
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart);
					msg.setContent(multipart);
					Transport.send(msg);
					System.out.println("email varification completion mail sended successfully to :"+req.getEmail());

				} catch (MessagingException e) {
					e.printStackTrace();
				}
			
			}

	@Override
	public String verifyRegisterUser(UserRegistrationRequest userForm) {
		return CommonUtility.userRequest(null,registerVerifyRequest(userForm), applicationConstantConfig.VERIFY_EMAIL);
		
	}
	public static String registerVerifyRequest(UserRegistrationRequest req) {
		JSONObject request= new JSONObject();		
		request.put("email", req.getMobile());	
		return request.toString();
	}
	
}