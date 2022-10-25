package com.mjunction.Main.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjunction.Main.model.ActiveJobs;
import com.mjunction.Main.model.ApplicantDetails;

@Repository
public interface JobsRepository extends JpaRepository<ActiveJobs,Long> {

	List<ActiveJobs> findByCompany(String company);
	List<ActiveJobs> findByDept(int dept);
	
	
	

	
	
	

}
