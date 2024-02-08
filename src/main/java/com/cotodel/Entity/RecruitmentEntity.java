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
@Table(name="recruitment")
@SequenceGenerator(name="recruitment_seq" , sequenceName="recruitment_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class RecruitmentEntity implements Serializable{
	
	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recruitment_seq")
	@Column(name="recruitment_id")
	private Long recruitmentId;
	
	@Column(name="position_id")
	private Long positionId;
	
	@Column(name="employer_id")
	private Long employerId;
	
	@Column(name="department_id")
	private Long departmentId;
	
	@CreationTimestamp
	@Column(name="Recruitment_date")
	private Date RecruitmentDate;
	private boolean status;
	

	@CreationTimestamp
	@Column(name="creation_date")
	private Date createionDate;
	
	@Column(name="recruitment_by")
	private String recruitmentBy;
	
	private String remarks;
	public Long getRecruitmentId() {
		return recruitmentId;
	}
	public void setRecruitmentId(Long recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	public Long getPositionId() {
		return positionId;
	}
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
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
	public Date getRecruitmentDate() {
		return RecruitmentDate;
	}
	public void setRecruitmentDate(Date recruitmentDate) {
		RecruitmentDate = recruitmentDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreateionDate() {
		return createionDate;
	}
	public void setCreateionDate(Date createionDate) {
		this.createionDate = createionDate;
	}
	public String getRecruitmentBy() {
		return recruitmentBy;
	}
	public void setRecruitmentBy(String recruitmentBy) {
		this.recruitmentBy = recruitmentBy;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	@Override
	public String toString() {
		return "RecruitmentEntity [recruitmentId=" + recruitmentId + ", positionId=" + positionId + ", employerId="
				+ employerId + ", departmentId=" + departmentId + ", RecruitmentDate=" + RecruitmentDate + ", status="
				+ status + ", createionDate=" + createionDate + ", recruitmentBy=" + recruitmentBy + ", remarks="
				+ remarks + "]";
	}
	

}
