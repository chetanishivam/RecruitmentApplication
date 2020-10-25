package com.luv2code.springboot.recruit.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Candidate {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateId;
	
	@Column(unique = true, nullable = false)
	@NotEmpty(message = "Candidate's email can not be empty.")
	private String candidateEmail;
	
	public Candidate() {
	}

	public Long getcandidateId() {
		return candidateId;
	}

	public void setcandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateEmail() {
		return candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
}
