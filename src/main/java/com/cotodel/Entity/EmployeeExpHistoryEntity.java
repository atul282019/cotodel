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
@Table(name="employee_exp_history")
@SequenceGenerator(name="employee_exp_history_seq" , sequenceName="employee_exp_history_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class EmployeeExpHistoryEntity implements Serializable{
	

	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_exp_history_seq")
	@Column(name="id")
	private Long id;
	
	@Column(name="org_id")
	private Long orgId;
	@Column(name="employee_id")
	private Long employeeId;
	@Column(name="employer_id")
	private Long employerId;
	
	@Column(name="org_name")
	private String orgName;
	
	@Column(name="domain")
	private String domain;
	
	@CreationTimestamp
	@Column(name="from_date")
	private Date fromDate;
	
	@CreationTimestamp
	@Column(name="to_date")
	private Date toDate;
	
	@Column(name="validation_status")
	private boolean validationStatus;
	private String extra1;
	private String extra2;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
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
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public boolean isValidationStatus() {
		return validationStatus;
	}
	public void setValidationStatus(boolean validationStatus) {
		this.validationStatus = validationStatus;
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
	@Override
	public String toString() {
		return "EmployeeExpHistoryEntity [id=" + id + ", orgId=" + orgId + ", employeeId=" + employeeId
				+ ", employerId=" + employerId + ", orgName=" + orgName + ", domain=" + domain + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", validationStatus=" + validationStatus + ", extra1=" + extra1
				+ ", extra2=" + extra2 + "]";
	}
	

}
