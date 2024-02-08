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
@Table(name="payroll")
@SequenceGenerator(name="payroll_seq" , sequenceName="payroll_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class PayrollEntity  implements Serializable{
	
	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="payroll_seq")
	@Column(name="payroll_id")
	private Long payrollId;
	
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="employer_id")
	private Long employerId;
	
	@Column(name="salary")
	private Long salary;
	
	private Long bonus;
	
	private Long detuction;
	
	@Column(name="net_salary")
	private Long netSalary;
	
	@CreationTimestamp
	@Column(name="payroll_date")
	private Date payrollDate;
	
	public Long getPayrollId() {
		return payrollId;
	}
	public void setPayrollId(Long payrollId) {
		this.payrollId = payrollId;
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
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public Long getBonus() {
		return bonus;
	}
	public void setBonus(Long bonus) {
		this.bonus = bonus;
	}
	public Long getDetuction() {
		return detuction;
	}
	public void setDetuction(Long detuction) {
		this.detuction = detuction;
	}
	public Long getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(Long netSalary) {
		this.netSalary = netSalary;
	}
	public Date getPayrollDate() {
		return payrollDate;
	}
	public void setPayrollDate(Date payrollDate) {
		this.payrollDate = payrollDate;
	}
	
	@Override
	public String toString() {
		return "PayrollEntity [payrollId=" + payrollId + ", employeeId=" + employeeId + ", employerId=" + employerId
				+ ", salary=" + salary + ", bonus=" + bonus + ", detuction=" + detuction + ", netSalary=" + netSalary
				+ ", payrollDate=" + payrollDate + "]";
	}
	
}
