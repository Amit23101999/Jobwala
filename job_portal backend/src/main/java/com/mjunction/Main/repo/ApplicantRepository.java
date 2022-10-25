package com.mjunction.Main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjunction.Main.model.ActiveJobs;
import com.mjunction.Main.model.ApplicantDetails;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantDetails, Long> {

	List<ApplicantDetails> findByCompany(String company);

	List<ApplicantDetails> findByJobCode(Long id);

	
	
	

}
