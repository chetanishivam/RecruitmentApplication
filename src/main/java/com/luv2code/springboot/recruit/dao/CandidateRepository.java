package com.luv2code.springboot.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.recruit.entity.Candidate;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>{}
