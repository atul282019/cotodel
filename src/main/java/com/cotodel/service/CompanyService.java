package com.cotodel.service;

import org.springframework.stereotype.Repository;

import com.cotodel.response.EmployeeProfileRequest;

@Repository
public interface CompanyService {

	String saveCompany(String token, EmployeeProfileRequest employeeProfileRequest);

}
