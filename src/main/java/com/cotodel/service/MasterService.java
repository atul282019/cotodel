package com.cotodel.service;

import org.springframework.stereotype.Repository;

import com.cotodel.response.UserRegistrationRequest;

@Repository
public interface MasterService {

	String getStateMaster(String token,UserRegistrationRequest userForm);

	String getOrgMaster(String token,UserRegistrationRequest userForm);

}
