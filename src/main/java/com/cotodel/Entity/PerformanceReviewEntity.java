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
@Table(name="performance_review")
@SequenceGenerator(name="performance_review_seq" , sequenceName="performance_review_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class PerformanceReviewEntity implements Serializable{
	
	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="performance_review_seq")
	@Column(name="review_id")
	private Long reviewId;
	
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="employer_id")
	private Long employerId;
	
	@CreationTimestamp
	@Column(name="review_date")
	private Date reviewDate;
	
	private String rating;
	private String comments;
	
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
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
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString() {
		return "PerformanceReviewEntity [reviewId=" + reviewId + ", employeeId=" + employeeId + ", employerId="
				+ employerId + ", reviewDate=" + reviewDate + ", rating=" + rating + ", comments=" + comments + "]";
	}
	
	
	

}
