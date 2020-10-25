package com.luv2code.springboot.recruit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.recruit.dao.ApplicationRepository;
import com.luv2code.springboot.recruit.dao.CandidateRepository;
import com.luv2code.springboot.recruit.dao.OfferRepository;
import com.luv2code.springboot.recruit.entity.Application;
import com.luv2code.springboot.recruit.entity.Offer;

@Service
public class ApplicationService {

	@Autowired
	protected ApplicationRepository applicationRepository;

	@Autowired
	protected OfferRepository offerRepository;

	@Autowired
	protected CandidateRepository candidateRepository;

	public Application getById(Long id) {
		Optional<Application> result = applicationRepository.findById(id);
		Application theApplication = null;
		if (result.isPresent()) {
			theApplication = result.get();
		} else {
			throw new RuntimeException("Application Not found - " + id);
		}
		return theApplication;
	}

	public List<Application> findAll() {
		return applicationRepository.findAll();
	}

	public Application applicationPerOffer(Long offerId, Long applicationId) {
		Optional<Application> result = applicationRepository.findByOfferId(offerId, applicationId);
		Application theApplication = null;
		if (result.isPresent()) {
			theApplication = result.get();
		} else {
			throw new RuntimeException("Application Not found - " + applicationId);
		}
		return theApplication;
	}

	public List<Application> applicationListPerOffer(Long offerId) {
		return applicationRepository.findApplicationListByOfferId(offerId);
	}

	@Transactional(readOnly = false)
	public Application saveApplication(Application application) {
		try {
			if (offerRepository.existsById(application.getOffer().getOfferId())) {
				if (candidateRepository.existsById(application.getCandidate().getcandidateId())) {
					application = applicationRepository.save(application);
					updateOffer(application.getOffer().getOfferId());
				} else {
					throw new RuntimeException("Candidate Does not exist");
				}
			} else {
				throw new RuntimeException("Offer Does not exist");
			}
		} catch (Exception e) {
			throw new RuntimeException("Candidate Already Applied");
		}
		return application;
	}

	protected void updateOffer(Long id) {
		Optional<Offer> result = offerRepository.findById(id);
		Offer theOffer = null;
		if (result.isPresent()) {
			theOffer = result.get();
		} else {
			throw new RuntimeException("Offer Not Found - " + id);
		}
		theOffer.setNumberOfApplication(theOffer.getNumberOfApplication() + 1);
		offerRepository.save(theOffer);
	}
}
