package com.mjunction.Main.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ApplicantDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private long phone;
	private String email;
	private String dob;
	private int exp;
	private String qualification;
	@Lob
	private byte[] resume;
	private String company;
	private Long jobCode;
//	private String status;
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Long getJobCode() {
		return jobCode;
	}

	public void setJobCode(Long jobCode2) {
		this.jobCode = jobCode2;
	}
	
	

	

	@Override
	public String toString() {
		return "ApplicantDetails [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", dob="
				+ dob + ", exp=" + exp + ", qualification=" + qualification + ", resume=" + Arrays.toString(resume)
				+ ", company=" + company + ", jobCode=" + jobCode + "]";
	}

	public ApplicantDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
