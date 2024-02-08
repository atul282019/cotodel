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
@Table(name="benefits")
@SequenceGenerator(name="benefits_seq" , sequenceName="benefits_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class BenefitsEntity implements Serializable{
	
	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="benefits_seq")
	@Column(name="benefit_id")
	private Long benefitId;
	
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="employer_id")
	private Long employerId;
	

	@CreationTimestamp
	@Column(name="start_date")
	private Date startDate;

	@CreationTimestamp
	@Column(name="end_date")
	private Date endDate;

	@CreationTimestamp
	@Column(name="creation_date")
	private Date creationDate;
	
	private String remarks;
	
	public Long getBenefitId() {
		return benefitId;
	}
	public void setBenefitId(Long benefitId) {
		this.benefitId = benefitId;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "BenefitsEntity [benefitId=" + benefitId + ", employeeId=" + employeeId + ", employerId=" + employerId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", creationDate=" + creationDate + ", remarks="
				+ remarks + "]";
	}
	
	
	
}
