package com.cotodel.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotodel.properties.ApplicationConstantConfig;
import com.cotodel.response.UserRegistrationRequest;
import com.cotodel.service.MasterService;
import com.cotodel.util.CommonUtility;

@Service
public class MasterServiceImpl implements MasterService{
	
	@Autowired
	public ApplicationConstantConfig applicationConstantConfig;

	@Override
	public String getStateMaster(String token,UserRegistrationRequest userForm) {
		return CommonUtility.userRequest(token,null, applicationConstantConfig.STATE_MASTER);
	}

	@Override
	public String getOrgMaster(String token,UserRegistrationRequest userForm) {
		return CommonUtility.userRequest(token,null, applicationConstantConfig.ORG_MASTER);
	}

}
