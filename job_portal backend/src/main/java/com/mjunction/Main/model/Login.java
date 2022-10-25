package com.mjunction.Main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String companyName;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(int id, String companyName, String password) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.password = password;
	}
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", companyName=" + companyName + ", password=" + password + "]";
	}
	
	
}
