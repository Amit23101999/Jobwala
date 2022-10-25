package com.mjunction.Main.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjunction.Main.model.ActiveJobs;
import com.mjunction.Main.repo.JobsRepository;

@Service
public class CompanyService {
	@Autowired
	private JobsRepository jRepo;
	
	

}
