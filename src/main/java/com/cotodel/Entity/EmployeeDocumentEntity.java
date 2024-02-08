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
@Table(name="employee_document")
@SequenceGenerator(name="employee_document_seq" , sequenceName="employee_document_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class EmployeeDocumentEntity  implements Serializable{
	

	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_document_seq")
	@Column(name="id")
	private Long id;
	
	@Column(name="doc_id")
	private Long docId;
	
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="employer_id")
	private Long employerId;
	
	@Column(name="document_type")
	private String documentType;
	
	@Column(name="doc_number")
	private String docNumber;
	
	private String url;
	
	@CreationTimestamp
	@Column(name="creation_date")
	private Date creationDate;
	
	@CreationTimestamp
	@Column(name="validation_date")
	private Date validationDate;
	
	@Column(name="validated_by")
	private String validatedBy;
	
	@Column(name="validation_report")
	private String validationReport;
	
	private String remarks;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDocId() {
		return docId;
	}
	public void setDocId(Long docId) {
		this.docId = docId;
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
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocNumber() {
		return docNumber;
	}
	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getValidationDate() {
		return validationDate;
	}
	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}
	public String getValidatedBy() {
		return validatedBy;
	}
	public void setValidatedBy(String validatedBy) {
		this.validatedBy = validatedBy;
	}
	public String getValidationReport() {
		return validationReport;
	}
	public void setValidationReport(String validationReport) {
		this.validationReport = validationReport;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "EmployeeDocumentEntity [id=" + id + ", docId=" + docId + ", employeeId=" + employeeId + ", employerId="
				+ employerId + ", documentType=" + documentType + ", docNumber=" + docNumber + ", url=" + url
				+ ", creationDate=" + creationDate + ", validationDate=" + validationDate + ", validatedBy="
				+ validatedBy + ", validationReport=" + validationReport + ", remarks=" + remarks + "]";
	}
	

}
