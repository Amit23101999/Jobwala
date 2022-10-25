package com.mjunction.Main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class JobStatus {
	
	@Id
	private long id;
	
	@Column(columnDefinition = "varchar(255) default 'Pending !'")
	private String status;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private ApplicantDetails applicantDetails;

	
	  public long getId() { return id; }
	  
	  public void setId(long id) { this.id = id; }
	 

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ApplicantDetails getApplicantDetails() {
		return applicantDetails;
	}

	public void setApplicantDetails(ApplicantDetails applicantDetails) {
		this.applicantDetails = applicantDetails;
	}

	public JobStatus(long id, String status, ApplicantDetails applicantDetails) {
		super();
		this.id = id;
		this.status = status;
		this.applicantDetails = applicantDetails;
	}

	public JobStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "JobStatus [id=" + id + ", status=" + status + ", applicantDetails=" + applicantDetails + "]";
	}

	
	
	
	

}
