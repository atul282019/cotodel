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
@Table(name="employer")
@SequenceGenerator(name="employer_seq" , sequenceName="employer_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class EmployerEntity implements Serializable{
	
	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employer_seq")
	@Column(name="employer_id")
	private Long employerId;
	
	
	@Column(name="signup_id")
	private Long signupId;
	
	@Column(name="org_name")
	private String orgName;
	
	@Column(name="gstin")
	private String gstin;
	@Column(name="no_of_Emp")
	private String noOfEmp;
	@Column(name="contact_number")
	private String contactNumber;
	
	private String email;
	private String address;
	private String pan;
	
	@Column(name="org_type")
	private String orgType;
	
	@Column(name="org_cat")
	private String orgCat;
	
	@Column(name="status")
	private boolean Status;
	
	private String extra1;
	private String extra2;
	private String extra3;
	private String extra4;
	
	private Integer intexta1;
	
	@Column(name="approved_by")
	private String approvedBy;
	

	@CreationTimestamp
	@Column(name="approval_date")
	private Date approvalDate;

	@CreationTimestamp
	@Column(name="creation_date")
	private Date creationDate;
	

	@CreationTimestamp
	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="schema_name")
	private String schemaName;
	
	@Column(name="db_name")
	private String dbName;
	
	@Column(name="ip_details")
	private String ipDetails;
	public Long getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}
	public Long getSignupId() {
		return signupId;
	}
	public void setSignupId(Long signupId) {
		this.signupId = signupId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getGstin() {
		return gstin;
	}
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	public String getNoOfEmp() {
		return noOfEmp;
	}
	public void setNoOfEmp(String noOfEmp) {
		this.noOfEmp = noOfEmp;
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
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getOrgCat() {
		return orgCat;
	}
	public void setOrgCat(String orgCat) {
		this.orgCat = orgCat;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
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
	public String getExtra4() {
		return extra4;
	}
	public void setExtra4(String extra4) {
		this.extra4 = extra4;
	}
	public Integer getIntexta1() {
		return intexta1;
	}
	public void setIntexta1(Integer intexta1) {
		this.intexta1 = intexta1;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public Date getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getIpDetails() {
		return ipDetails;
	}
	public void setIpDetails(String ipDetails) {
		this.ipDetails = ipDetails;
	}
	
	@Override
	public String toString() {
		return "EmployerEntity [employerId=" + employerId + ", signupId=" + signupId + ", orgName=" + orgName
				+ ", gstin=" + gstin + ", noOfEmp=" + noOfEmp + ", contactNumber=" + contactNumber + ", email=" + email
				+ ", address=" + address + ", pan=" + pan + ", orgType=" + orgType + ", orgCat=" + orgCat + ", Status="
				+ Status + ", extra1=" + extra1 + ", extra2=" + extra2 + ", extra3=" + extra3 + ", extra4=" + extra4
				+ ", intexta1=" + intexta1 + ", approvedBy=" + approvedBy + ", approvalDate=" + approvalDate
				+ ", creationDate=" + creationDate + ", updateDate=" + updateDate + ", schemaName=" + schemaName
				+ ", dbName=" + dbName + ", ipDetails=" + ipDetails + "]";
	}
	
	
}
