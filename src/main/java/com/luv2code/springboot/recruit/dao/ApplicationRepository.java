package com.luv2code.springboot.recruit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.recruit.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

	@Query("SELECT a FROM Application a WHERE OFFER_ID = ?1")
	List<Application> findApplicationListByOfferId(Long id);

	@Query("SELECT a FROM Application a WHERE OFFER_ID = ?1 AND APPLICATION_ID = ?2")
	Optional<Application> findByOfferId(Long idOffer, Long idApp);
}