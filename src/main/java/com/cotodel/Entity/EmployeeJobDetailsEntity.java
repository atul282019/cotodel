package com.cotodel.Entity;

import java.io.Serializable;

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
import java.util.Date;

@Entity
@Table(name="employee_job_details")
@SequenceGenerator(name="employee_job_details_seq" , sequenceName="employee_job_details_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class EmployeeJobDetailsEntity implements Serializable{
	
	private static final long serialVersionUID = 4615208660281419839L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_job_details_seq")
	@Column(name="job_detail_id")
	private Long jobDetailId;
	
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="employer_id")
	private Long employerId;
	
	@Column(name="department_id")
	private Long departmentId;
	
	@Column(name="position_id")
	private Long positionId;
	
	@Column(name="employment_type")
	private String employmentType;
	

	@CreationTimestamp
	@Column(name="joining_date")
	private Date joiningDate;


	public Long getJobDetailId() {
		return jobDetailId;
	}


	public void setJobDetailId(Long jobDetailId) {
		this.jobDetailId = jobDetailId;
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


	public Long getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


	public Long getPositionId() {
		return positionId;
	}


	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}


	public String getEmploymentType() {
		return employmentType;
	}


	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}


	public Date getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}


}
