package com.mjunction.Main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjunction.Main.model.ApplicantDetails;
import com.mjunction.Main.repo.ApplicantRepository;

@Service
public class ApplicantService {
	
	@Autowired
	ApplicantRepository aRepo;
	
	public void deleteAllAppliedjobs(List<ApplicantDetails> applicantDetails)
	{
		for(ApplicantDetails apd:applicantDetails)
		{
			aRepo.delete(apd);
		}
	}

}
