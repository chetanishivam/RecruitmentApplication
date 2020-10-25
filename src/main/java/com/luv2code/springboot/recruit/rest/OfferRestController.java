package com.luv2code.springboot.recruit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.recruit.entity.Offer;
import com.luv2code.springboot.recruit.service.OfferService;


@RestController
@RequestMapping("/offer/")
public class OfferRestController {

	@Autowired
	private OfferService offerService;
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<?> getOffer(@PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(offerService.getById(id));
    }
	
	@GetMapping(value = "/")
    public ResponseEntity<List<Offer>> listOffers(){
        return ResponseEntity.status(HttpStatus.OK).body(offerService.findAll());
    }
	
	
	@PostMapping(value = "/")
    public ResponseEntity<?> saveOffer(@RequestBody Offer offer) throws Exception{
		// also just in case they pass an id in JSON...set id to 0
		// this is to force a save of new item...instead of update
		offer.setOfferId(0L);
		offer = offerService.saveOffer(offer);
		return ResponseEntity.status(HttpStatus.OK).body("Offer successfully created.Generated Offer Id: "+offer.getOfferId());
    }
	@PutMapping(value = "/")
    public ResponseEntity<?> updateOffer(@RequestBody Offer offer) throws Exception{
        offer = offerService.saveOffer(offer);
		
		return ResponseEntity.status(HttpStatus.OK).body("Offer successfully updated.");
    }
}
