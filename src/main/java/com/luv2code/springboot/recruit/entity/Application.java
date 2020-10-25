package com.luv2code.springboot.recruit.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"OFFER_ID", "CANDIDATE_ID"})}) 
public class Application {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationId;
	
	@ManyToOne
	@JoinColumn(name = "OFFER_ID")
	private Offer offer;
	
	@OneToOne
	@JoinColumn(name = "CANDIDATE_ID")
	private Candidate candidate;
	
	@Enumerated(EnumType.STRING)
    private EnumApplicationStatus status;
	
	@Column(length = 500)
	@Size(max = 500, message = "500 characters allowed")
	private String resumeText;
	
	public Application() {
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public EnumApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(EnumApplicationStatus status) {
		this.status = status;
	}

	public String getResumeText() {
		return resumeText;
	}

	public void setResumeText(String resumeText) {
		this.resumeText = resumeText;
	}
}
