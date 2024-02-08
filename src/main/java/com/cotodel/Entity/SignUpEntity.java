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
@Table(name="sign_up")
@SequenceGenerator(name="signup_seq" , sequenceName="signup_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class SignUpEntity implements Serializable{
	
	
	private static final long serialVersionUID = 4615208660281419839L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="signup_seq")
	@Column(name="signup_id")
	private Long signupId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@CreationTimestamp
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	private String gender;
	
	@Column(name="contact_number")
	private String contactNumber;
	private String email;
	private String address;
	
	@Column(name="org_type")
	private String orgType;
	
	@Column(name="org_name")
	private String orgName;
	
	private String mobile;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="v_status_email")
	private String vstatusEmail;
	
	@Column(name="v_status_mobile")
	private String vstatusMobile;
	
	@CreationTimestamp
	@Column(name="v_status_email_date")
	private Date vstatusEmailDate;
	
	@CreationTimestamp
	@Column(name="v_status_mobile_date")
	private Date vstatusMobileDate;
	
	private String username;
	private String pwd;
	private boolean status;
	private Long intextra;
	private String extra1;

	private String extra2;
	private String extra3;
	private String intextra1;
	private String freetext;
	private String remarks;
	@Column(name="employee_id")
	private Long employeeId;
	
	public Long getSignupId() {
		return signupId;
	}
	public void setSignupId(Long signupId) {
		this.signupId = signupId;
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
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getVstatusEmail() {
		return vstatusEmail;
	}
	public void setVstatusEmail(String vstatusEmail) {
		this.vstatusEmail = vstatusEmail;
	}
	public String getVstatusMobile() {
		return vstatusMobile;
	}
	public void setVstatusMobile(String vstatusMobile) {
		this.vstatusMobile = vstatusMobile;
	}
	public Date getVstatusEmailDate() {
		return vstatusEmailDate;
	}
	public void setVstatusEmailDate(Date vstatusEmailDate) {
		this.vstatusEmailDate = vstatusEmailDate;
	}
	public Date getVstatusMobileDate() {
		return vstatusMobileDate;
	}
	public void setVstatusMobileDate(Date vstatusMobileDate) {
		this.vstatusMobileDate = vstatusMobileDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Long getIntextra() {
		return intextra;
	}
	public void setIntextra(Long intextra) {
		this.intextra = intextra;
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
	public String getExtra3() {
		return extra3;
	}
	public void setExtra3(String extra3) {
		this.extra3 = extra3;
	}
	public String getIntextra1() {
		return intextra1;
	}
	public void setIntextra1(String intextra1) {
		this.intextra1 = intextra1;
	}
	public String getFreetext() {
		return freetext;
	}
	public void setFreetext(String freetext) {
		this.freetext = freetext;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "SignUpEntity [signupId=" + signupId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", contactNumber=" + contactNumber
				+ ", email=" + email + ", address=" + address + ", orgType=" + orgType + ", orgName=" + orgName
				+ ", mobile=" + mobile + ", creationDate=" + creationDate + ", vstatusEmail=" + vstatusEmail
				+ ", vstatusMobile=" + vstatusMobile + ", vstatusEmailDate=" + vstatusEmailDate + ", vstatusMobileDate="
				+ vstatusMobileDate + ", username=" + username + ", pwd=" + pwd + ", status=" + status + ", intextra="
				+ intextra + ", extra1=" + extra1 + ", extra2=" + extra2 + ", extra3=" + extra3 + ", intextra1="
				+ intextra1 + ", freetext=" + freetext + ", remarks=" + remarks + ", employeeId=" + employeeId + "]";
	}
	
	
	


}
