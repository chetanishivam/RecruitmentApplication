package com.luv2code.springboot.recruit.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.recruit.dao.OfferRepository;
import com.luv2code.springboot.recruit.entity.Offer;

@Service
public class OfferService {

	@Autowired
	protected OfferRepository offerRepository;

	public Offer getById(Long id) throws Exception {
		Optional<Offer> result = offerRepository.findById(id);
		Offer theOffer = null;
		if (result.isPresent()) {
			theOffer = result.get();
		} else {
			throw new RuntimeException("Offer Not Found - " + id);
		}
		return theOffer;
	}

	public List<Offer> findAll() {
		return offerRepository.findAll();
	}

	public Offer saveOffer(Offer offer) throws Exception {
		offer.setNumberOfApplication(0);
		try {
			offer = offerRepository.save(offer);
		} catch (Exception e) {
			throw new RuntimeException("Offer Already Exist");
		}
		return offer;
	}
}
