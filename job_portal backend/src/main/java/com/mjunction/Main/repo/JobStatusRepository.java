package com.mjunction.Main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjunction.Main.model.JobStatus;

@Repository
public interface JobStatusRepository extends JpaRepository<JobStatus, Long>{

	JobStatus findByApplicantDetailsId(long id);
	
	

}
