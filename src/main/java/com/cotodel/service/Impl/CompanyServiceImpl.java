package com.cotodel.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotodel.properties.ApplicationConstantConfig;
import com.cotodel.response.EmployeeProfileRequest;
import com.cotodel.service.CompanyService;
import com.cotodel.util.CommonUtility;
import com.cotodel.util.MessageConstant;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	public ApplicationConstantConfig applicationConstantConfig;
	
	@Override
	public String saveCompany(String token, EmployeeProfileRequest employeeProfileRequest) {
		return CommonUtility.userRequest(token,MessageConstant.gson.toJson(employeeProfileRequest), applicationConstantConfig.CREARE_COMPANY);
	}
	
	

}
