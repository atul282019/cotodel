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
@Table(name="leave")
@SequenceGenerator(name="leave_seq" , sequenceName="leave_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class LeaveEntity implements Serializable{
	
	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="leave_seq")
	@Column(name="leave_id")
	private Long leaveId;
	
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="employer_id")
	private Long employerId;
	
	@Column(name="leave_type")
	private String leaveType;
	

	@CreationTimestamp
	@Column(name="start_date")
	private Date startDate;

	@CreationTimestamp
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="leave_status")
	private String leaveStatus;
	

	@CreationTimestamp
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="approoved_by")
	private String approovedBy;
	

	@CreationTimestamp
	@Column(name="approval_date")
	private Date ApprovalDate;
	
	private String remarks;
	public Long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
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
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
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
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getApproovedBy() {
		return approovedBy;
	}
	public void setApproovedBy(String approovedBy) {
		this.approovedBy = approovedBy;
	}
	public Date getApprovalDate() {
		return ApprovalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		ApprovalDate = approvalDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return "LeaveEntity [leaveId=" + leaveId + ", employeeId=" + employeeId + ", employerId=" + employerId
				+ ", leaveType=" + leaveType + ", startDate=" + startDate + ", endDate=" + endDate + ", leaveStatus="
				+ leaveStatus + ", creationDate=" + creationDate + ", approovedBy=" + approovedBy + ", ApprovalDate="
				+ ApprovalDate + ", remarks=" + remarks + "]";
	}
	
	

}
