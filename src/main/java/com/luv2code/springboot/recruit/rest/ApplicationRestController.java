package com.luv2code.springboot.recruit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.recruit.entity.Application;
import com.luv2code.springboot.recruit.entity.EnumApplicationStatus;
import com.luv2code.springboot.recruit.service.ApplicationService;

@RestController
@RequestMapping("/application/")
public class ApplicationRestController {

	@Autowired
	private ApplicationService applicationService;

	@GetMapping(value = "/")
	public ResponseEntity<List<Application>> listApplications() {
		return ResponseEntity.status(HttpStatus.OK).body(applicationService.findAll());
	}

	@GetMapping(value = "/offer/{offerId}")
	public ResponseEntity<List<Application>> listApplicationsByOffer(@PathVariable Long offerId) {
		return ResponseEntity.status(HttpStatus.OK).body(applicationService.applicationListPerOffer(offerId));
	}

	@GetMapping(value = "/offer/{offerId}/{applicationId}")
	public ResponseEntity<?> applicationsByOffer(@PathVariable Long offerId, @PathVariable Long applicationId) {
		return ResponseEntity.status(HttpStatus.OK)
				.body((applicationService.applicationPerOffer(offerId, applicationId)));
	}

	@GetMapping(value = "/{applicationId}")
	public ResponseEntity<?> getApplication(@PathVariable Long applicationId) {
		return ResponseEntity.status(HttpStatus.OK).body(applicationService.getById(applicationId));
	}

	@PostMapping(value = "/apply/")
	public ResponseEntity<?> saveApplication(@RequestBody Application application) {
		application.setStatus(EnumApplicationStatus.APPLIED);
		application.setApplicationId(0L);
		application = applicationService.saveApplication(application);
		return ResponseEntity.status(HttpStatus.OK).body("Applied Successfully");
	}

}
