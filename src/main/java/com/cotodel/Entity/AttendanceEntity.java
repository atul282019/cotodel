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

@Entity
@Table(name="attendance")
@SequenceGenerator(name="attendance_seq" , sequenceName="attendance_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class AttendanceEntity implements Serializable{
	
	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="attendance_seq")
	@Column(name="attendance_id")
	private Long attendanceId;
	
	@Column(name="employer_id")
	private Long employerId;
	
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="attendance_date")
	private Date attendanceDate;
	
	@Column(name="clock_in_time")
	private Date clockInTime;
	
	@Column(name="clock-out_time")
	private Date clockOutTime;
	
	public Long getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(Long attendanceId) {
		this.attendanceId = attendanceId;
	}
	public Long getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public Date getClockInTime() {
		return clockInTime;
	}
	public void setClockInTime(Date clockInTime) {
		this.clockInTime = clockInTime;
	}
	public Date getClockOutTime() {
		return clockOutTime;
	}
	public void setClockOutTime(Date clockOutTime) {
		this.clockOutTime = clockOutTime;
	}
	
	@Override
	public String toString() {
		return "AttendanceEntity [attendanceId=" + attendanceId + ", employerId=" + employerId + ", employeeId="
				+ employeeId + ", attendanceDate=" + attendanceDate + ", clockInTime=" + clockInTime + ", clockOutTime="
				+ clockOutTime + "]";
	}
	
	
}
