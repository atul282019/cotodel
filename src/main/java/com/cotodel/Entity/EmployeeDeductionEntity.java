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
@Table(name="employee_deduction")
@SequenceGenerator(name="employee_deduction_seq" , sequenceName="employee_deduction_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class EmployeeDeductionEntity implements Serializable{
	

	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_deduction_seq")
	@Column(name="id")
	private Long id;
	
	@Column(name="education_id")
	private Long educationId;
	
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="employer_id")
	private Long employerId;
	
	@CreationTimestamp
	@Column(name="from_date")
	private Date fromDate;
	
	@CreationTimestamp
	@Column(name="to_date")
	private Date toDate;
	private Long marks;
	
	@Column(name="max_marks")
	private Long maxMarks;
	
	@Column(name="validation_status")
	private boolean validationStatus;
	
	@Column(name="digi_locker_path")
	private String digiLockerPath;
	
	private String extra1;
	private String extra2;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEducationId() {
		return educationId;
	}
	public void setEducationId(Long educationId) {
		this.educationId = educationId;
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
	public Long getMarks() {
		return marks;
	}
	public void setMarks(Long marks) {
		this.marks = marks;
	}
	public Long getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(Long maxMarks) {
		this.maxMarks = maxMarks;
	}
	public boolean isValidationStatus() {
		return validationStatus;
	}
	public void setValidationStatus(boolean validationStatus) {
		this.validationStatus = validationStatus;
	}
	public String getDigiLockerPath() {
		return digiLockerPath;
	}
	public void setDigiLockerPath(String digiLockerPath) {
		this.digiLockerPath = digiLockerPath;
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
		return "EmployeeDeductionEntity [id=" + id + ", educationId=" + educationId + ", employeeId=" + employeeId
				+ ", employerId=" + employerId + ", fromDate=" + fromDate + ", toDate=" + toDate + ", marks=" + marks
				+ ", maxMarks=" + maxMarks + ", validationStatus=" + validationStatus + ", digiLockerPath="
				+ digiLockerPath + ", extra1=" + extra1 + ", extra2=" + extra2 + "]";
	}
	
	

}
