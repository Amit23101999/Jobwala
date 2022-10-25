package com.mjunction.Main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mjunction.Main.model.ActiveJobs;
import com.mjunction.Main.model.ApplicantDetails;
import com.mjunction.Main.model.JobStatus;
import com.mjunction.Main.repo.ApplicantRepository;
import com.mjunction.Main.repo.JobStatusRepository;
import com.mjunction.Main.repo.JobsRepository;

/* This is for job seeker */
@CrossOrigin("*")
@RestController
public class ApplicantController {
	@Autowired
	JobsRepository jRepo;
	@Autowired
	ApplicantRepository aRepo;
	
	@Autowired
	JobStatusRepository jSRepo;

	/* To get all the applicants */
	@GetMapping("/applicants")
	public List<ApplicantDetails> getApplicants() {
		return aRepo.findAll();
	}

	/* To get the jobs based on the department */
	@GetMapping("/jobsbydept/{dept}")
	public ResponseEntity<List<ActiveJobs>> getJobsByDept(@PathVariable int dept) {

		List<ActiveJobs> activeJobs = jRepo.findByDept(dept);
		return ResponseEntity.ok(activeJobs);
	}

	/*
	 * To apply for a job
	 * 
	 * @PostMapping("/apply-for-job") public ResponseEntity<Map<String, Boolean>>
	 * createJob(@RequestBody ApplicantDetails ad) { Map<String, Boolean> response =
	 * new HashMap<>(); response.put("profile Created", Boolean.TRUE);
	 * 
	 * ApplicantDetails applicantDetails = aRepo.save(ad);
	 * //System.out.println(applicantDetails.getId()); String
	 * applicantDetailsId="Your application Id is::"+applicantDetails.getId()
	 * +"\n please Note it for future reference.";
	 * //ResponseEntity.ok(applicantDetails); return new
	 * ResponseEntity(applicantDetailsId, HttpStatus.FOUND); //return
	 * ResponseEntity.ok(response); }
	 */

    @PostMapping("/apply-for-job")
    public String createJob(@RequestBody ApplicantDetails ad) {
          Map<String, Boolean> response = new HashMap<>();
          response.put("profile Created", Boolean.TRUE);
          ActiveJobs aj=jRepo.findById(ad.getJobCode()).orElseThrow();
          //ad.setJobCode(jobCode);
          ad.setCompany(aj.getCompany());
          ApplicantDetails applicantDetails = aRepo.save(ad);
          
          JobStatus jobStatus=new JobStatus();
          jobStatus.setApplicantDetails(ad);
          jobStatus.setStatus("pending");
          jSRepo.save(jobStatus);
          
          System.out.println(applicantDetails);
          // System.out.println(applicantDetails.getId()); 
          String applicantDetailsId = "Your application Id is::" + applicantDetails.getId()
                       + "\n please Note it for future reference.";
          // ResponseEntity.ok(applicantDetails); return new
          return applicantDetailsId; 
          // return ResponseEntity.ok(response);
    }

	
	
	
	/* To get the Status of job*/
	@GetMapping("get-status-of-job/{id}")
	public String getJobStatus(@PathVariable int id)
	{
		String status=null;
		
		JobStatus js=jSRepo.findByApplicantDetailsId(id);
		//List<JobStatus> js=jSRepo.findAll();
		
		
		
		System.out.println(js);
				
		return js.getStatus();
	}
}
