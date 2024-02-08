package com.cotodel.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@CrossOrigin(origins = "", allowedHeaders = "")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CotoDelAdminFilter implements Filter, WebMvcConfigurer{

	
	//Logger logger = LoggerFactory.getLogger(CotoDelAdminFilter.class);
	
	FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig){
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		 
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String requestURI = httpServletRequest.getRequestURI();
		
		boolean isStaticResource1 = httpServletRequest.getRequestURI().contains("cotodel-js/");
		boolean isStaticResource2 = httpServletRequest.getRequestURI().contains("vendor/");
		boolean isStaticResource3 = httpServletRequest.getRequestURI().contains("images/");
		boolean isStaticResourceJs = httpServletRequest.getRequestURI().contains("js/");
		boolean isStaticResourceCss = httpServletRequest.getRequestURI().contains("css/");
		boolean isStaticResourceSass = httpServletRequest.getRequestURI().contains("scss/");
		boolean isStaticResourceImg = httpServletRequest.getRequestURI().contains("img/");
		HttpSession session = httpServletRequest.getSession(false);
		
		
		HttpServletResponse res = (HttpServletResponse) response;
		//logger.info("inside cors filter method == "+httpServletRequest.getMethod()+" || "+httpServletRequest.getRequestURI());
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
        res.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept,"
        		+ " X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers , Authorization,Access-Control-Allow-Origin");

        if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
        	res.setStatus(HttpServletResponse.SC_OK);
        	res.setContentType("application/json");
        } 
			

		if (session == null) {
			session = httpServletRequest.getSession(true);
		}
		String login = (String) session.getAttribute("cotodel");
		//String login = (String) session.getAttribute("Bis_Login");
		//logger.info("login"+login);
		//logger.info("request uri-------------"+requestURI);
		if(login==null){	
			if( isStaticResourceImg || isStaticResource1 || isStaticResource2 || isStaticResource3 
					|| isStaticResourceJs || isStaticResourceCss || isStaticResourceSass) {
						chain.doFilter(request, response);
			}else if(requestURI.contains("/index")){
				RequestDispatcher rd = request.getRequestDispatcher("index");
				rd.forward(request, response);
			}else if(requestURI.contains("/login")){
				RequestDispatcher rd = request.getRequestDispatcher("login");
				rd.forward(request, response);
			}else if(requestURI.contains("/signup")){
				RequestDispatcher rd = request.getRequestDispatcher("signup");
				rd.forward(request, response);
			}
			else if(requestURI.contains("/smsOtpSender")){
				RequestDispatcher rd = request.getRequestDispatcher("smsOtpSender");
				rd.forward(request, response);
			}
			else if(requestURI.contains("/userLogin")){
				RequestDispatcher rd = request.getRequestDispatcher("userLogin");
				rd.forward(request, response);
			}
			else if(requestURI.contains("/registerUser")){
				RequestDispatcher rd = request.getRequestDispatcher("registerUser");
				rd.forward(request, response);
			}else if(requestURI.contains("/token")){
				RequestDispatcher rd = request.getRequestDispatcher("token");
				rd.forward(request, response);
			}
			else if(requestURI.contains("/confirm")){
				RequestDispatcher rd = request.getRequestDispatcher("confirm");
				rd.forward(request, response);
			}else if(requestURI.contains("/verifyRegisterUser")){
				RequestDispatcher rd = request.getRequestDispatcher("verifyRegisterUser");
				rd.forward(request, response);
			}
			else if(requestURI.contains("/companyDetails")){
				RequestDispatcher rd = request.getRequestDispatcher("companyDetails");
				rd.forward(request, response);
			}
			else if(requestURI.contains("/dashboard1")){
				RequestDispatcher rd = request.getRequestDispatcher("dashboard1");
				rd.forward(request, response);
			}
			else if(requestURI.contains("/companyDetails01")){
				RequestDispatcher rd = request.getRequestDispatcher("companyDetails01");
				rd.forward(request, response);
			}
			else if(requestURI.contains("/logout")){
				RequestDispatcher rd = request.getRequestDispatcher("logout");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("index");
				rd.forward(request, response);
			}
		}else{
			chain.doFilter(request, response);
		} 
	}
	
	public void destroy() {
		
	}
	
}
