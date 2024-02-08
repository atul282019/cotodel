package com.cotodel.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="employee")
@SequenceGenerator(name="employee_seq" , sequenceName="employee_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class EmployeeEntity implements Serializable{
	
	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_seq")
	
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="employer_id")
	private Long employerId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@CreationTimestamp
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	private String gender;
	
	@Column(name="mobile")
	private String Mobile;
	
	@Column(name="pic_url")
	private String picUrl;
	
	private String email;
	
	private String address;
	
	@Column(name="role_id")
	private Long roleId;
	
	private String user;
	
	private String pwd;
	
	@Column(name="bank_account")
	private String bankAccount;
	
	private String ifsc;
	
	private String urn;
	
	private String pan;
	
	private String aadhaar;
	
	private String extra1;
	
	private String extra2;
	
	private boolean status;
	
	private String intextra1;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getUrn() {
		return urn;
	}
	public void setUrn(String urn) {
		this.urn = urn;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}
	public String getExtra1() {
		return extra1;
	}
	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}
	public String getExtra2() {
		return extra2;
	}
	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getIntextra1() {
		return intextra1;
	}
	public void setIntextra1(String intextra1) {
		this.intextra1 = intextra1;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", employerId=" + employerId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", Mobile="
				+ Mobile + ", picUrl=" + picUrl + ", email=" + email + ", address=" + address + ", roleId=" + roleId
				+ ", user=" + user + ", pwd=" + pwd + ", bankAccount=" + bankAccount + ", ifsc=" + ifsc + ", urn=" + urn
				+ ", pan=" + pan + ", aadhaar=" + aadhaar + ", extra1=" + extra1 + ", extra2=" + extra2 + ", status="
				+ status + ", intextra1=" + intextra1 + "]";
	}
	
	
	

}
