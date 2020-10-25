package com.luv2code.springboot.recruit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;



@Entity
public class Offer{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long offerId;
	
	@Column(unique = true)
	@NotEmpty(message = "Job Title can not be empty.")
	private String jobTitle;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column()
	private Integer numberOfApplication;

	public Offer() {
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getNumberOfApplication() {
		return numberOfApplication;
	}

	public void setNumberOfApplication(Integer numberOfApplication) {
		this.numberOfApplication = numberOfApplication;
	}
}
