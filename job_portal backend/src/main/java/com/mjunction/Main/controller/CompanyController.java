package com.mjunction.Main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mjunction.Main.Service.ApplicantService;
import com.mjunction.Main.model.ActiveJobs;
import com.mjunction.Main.model.ApplicantDetails;
import com.mjunction.Main.model.JobStatus;
import com.mjunction.Main.model.Login;
import com.mjunction.Main.repo.ApplicantRepository;
import com.mjunction.Main.repo.JobStatusRepository;
import com.mjunction.Main.repo.JobsRepository;

@CrossOrigin("*")
@RestController

public class CompanyController {

	@Autowired
	JobsRepository jRepo;
	
	@Autowired
	ApplicantRepository aRepo;
	
	@Autowired
	ApplicantService aServ;
	
	@Autowired
	JobStatusRepository jSRepo;

	/* TO get ALLL the jobs */
	@GetMapping("/jobs")
	public List<ActiveJobs> getUsers() {
		return jRepo.findAll();
	}

	/* TO create jobs as a company (It will go to a form for creating jobs) */
	@PostMapping("/create-jobs")
	public ResponseEntity<Map<String, Boolean>> createJob(@RequestBody ActiveJobs aj) {
		Map<String, Boolean> response = new HashMap<>();
		response.put("Job Created", Boolean.TRUE);
		ActiveJobs ajc = jRepo.save(aj);
		ResponseEntity.ok(ajc);
		return ResponseEntity.ok(response);
	}

	/* To get the jobs based on the name of company */
	@GetMapping("/jobs/{company}")
	public ResponseEntity<List<ActiveJobs>> getJobsByCompany(@PathVariable String company) {

		List<ActiveJobs> activeJobs = jRepo.findByCompany(company);
		return ResponseEntity.ok(activeJobs);
	}
	/* To get all the applicant details based on jobCode*/
    @GetMapping("/get-applicants-on-jobcode/{jobCode}")
    public ResponseEntity<List<ApplicantDetails>> getApplicantsOnJobCode(@PathVariable long jobCode)
    {
          List<ApplicantDetails> appliedJobs = aRepo.findByJobCode(jobCode);
          System.out.println(appliedJobs);
          return ResponseEntity.ok(appliedJobs);
    }


	/* To update job by id */
	@PutMapping("/updatejobs/{id}")
	public ResponseEntity<Map<String, Boolean>> updateJob(@PathVariable Long id,
			@RequestBody ActiveJobs activejobDetails) {

		Map<String, Boolean> response = new HashMap<>();
		ActiveJobs activeJobs = jRepo.findById(id).orElseThrow();

//		activeJobs.setDept(activejobDetails.getDept());
//		activeJobs.setCompany(activejobDetails.getCompany());
		activeJobs.setDescrp(activejobDetails.getDescrp());
		activeJobs.setRole(activejobDetails.getRole());
		activeJobs.setSalary(activejobDetails.getSalary());
		activeJobs.setExp(activejobDetails.getExp());

		ActiveJobs updatedActiveJobs = jRepo.save(activeJobs);
		ResponseEntity.ok(updatedActiveJobs);
		return ResponseEntity.ok(response);

	}

	/* To Delete a job by id */
	@DeleteMapping("/deletejob/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteJob(@PathVariable Long id) {
		ActiveJobs activeJobs = jRepo.findById(id).orElseThrow();
		List<ApplicantDetails> applicantDetails=aRepo.findByJobCode(id);
		//System.out.println(applicantDetails);
		aServ.deleteAllAppliedjobs(applicantDetails);
		//System.out.println(activeJobs);
		//aRepo.delete(applicantDetails);
		

		jRepo.delete(activeJobs);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	/*To see the applied jobs for a particular company*/
	@GetMapping("/getAppliedJobs/{company}")
	public ResponseEntity<List<ApplicantDetails>> getAppliedJobs(@PathVariable String company)
	{
		List<ApplicantDetails> appliedJobs = aRepo.findByCompany(company);
		//System.out.println(appliedJobs);
		return ResponseEntity.ok(appliedJobs);
	}
	
	/* To set the status of the job By the Company*/
    //@PutMapping("/setstatus/{status}/{id}")
//	@PostMapping("/setstatus/{status}/{id}")
//    public String setStatus(@PathVariable long id,@PathVariable String status)
//    {
////          Map<String, Boolean> response = new HashMap<>();
//          
//          JobStatus js=jSRepo.findByApplicantDetailsId(id);
//          js.setStatus(status);
//          jSRepo.save(js);
//          return "Successfully Changed!!";
//          
//         // return ResponseEntity.ok(response);
//    }
//    

	@PostMapping("/setstatus")
    public String setStatus(@RequestBody JobStatus jobstatus)
    {
          
          JobStatus jS=jobstatus;
          jS.setStatus(jobstatus.getStatus());
          jSRepo.delete(jobstatus);
          jSRepo.save(jS);
          
          
          
          return "succesfully Changed";
    }


}
