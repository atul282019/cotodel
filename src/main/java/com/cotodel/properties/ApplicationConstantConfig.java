package com.cotodel.properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@Configuration
@PropertySource({"classpath:application.properties"})
public class ApplicationConstantConfig {

	
	@Value("${GET_OTP}")
	public String GET_OTP;

	@Value("${VERFY_OTP}")
	public String VERFY_OTP;

	@Value("${REGISTER_USER}")
	public String REGISTER_USER;
	
	@Value("${VERIFY_EMAIL}")
	public String VERIFY_EMAIL;
	
	@Value("${getTokenUrl}")
	public String getTokenUrl;
	
	
	
}
