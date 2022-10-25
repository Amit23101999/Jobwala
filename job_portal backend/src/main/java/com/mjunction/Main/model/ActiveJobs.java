package com.mjunction.Main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActiveJobs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String role; /*example- application developer*/
	private String company; 
	@Column(name = "descreption")
	private String descrp; /*example- Knowlwdge in the following areas- java ee, spring etc */
	private int exp; /*Experience*/
	private String salary;
	/* dept=1 for tech , 2 for medical , 3 for HR , 4 for Marketing&Sales*/
	private int dept;
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDescrp() {
		return descrp;
	}
	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public ActiveJobs(Long id, String role, String company, String descrp, int exp, String salary, int dept) {
		super();
		this.id = id;
		this.role = role;
		this.company = company;
		this.descrp = descrp;
		this.exp = exp;
		this.salary = salary;
		this.dept = dept;
	}
	public ActiveJobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ActiveJobs [id=" + id + ", role=" + role + ", company=" + company + ", descrp=" + descrp + ", exp="
				+ exp + ", salary=" + salary + ", dept=" + dept + "]";
	}
	
	

}
