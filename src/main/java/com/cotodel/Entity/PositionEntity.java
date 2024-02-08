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



@Entity
@Table(name="position")
@SequenceGenerator(name="position_seq" , sequenceName="position_seq", allocationSize=1)
@Access(value=AccessType.FIELD)
public class PositionEntity implements Serializable{
	
	private static final long serialVersionUID = 4615208660281419839L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="position_seq")
	@Column(name="position_id")
	private Long positionId;
	
	@Column(name="position_title")
	private String positionTitle;
	
	@Column(name="employer_id")
	private Long employerId;
	
	public Long getPositionId() {
		return positionId;
	}
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	public String getPositionTitle() {
		return positionTitle;
	}
	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}
	public Long getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}
	@Override
	public String toString() {
		return "PositionEntity [positionId=" + positionId + ", positionTitle=" + positionTitle + ", employerId="
				+ employerId + "]";
	}
	
}
