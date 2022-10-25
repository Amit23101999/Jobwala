package com.mjunction.Main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjunction.Main.model.Login;
import com.mjunction.Main.repo.LoginRepository;

@CrossOrigin("*")
@RestController

public class LoginController {
	
	@Autowired
	LoginRepository lgRepo;
	
	/* To get all the admins who signed up*/
	@GetMapping("/users")
	public List<Login> getUsers()
	{
		return lgRepo.findAll();
	}
	
	/*To Signup/Register as a user*/

	@PostMapping("/signup")
	public ResponseEntity<Map<String,Boolean>> addUser(@RequestBody Login lc)
	{
		Map<String,Boolean> response= new HashMap<>();
		response.put("User Created", Boolean.TRUE);
		Login lgc=lgRepo.save(lc);
		ResponseEntity.ok(lgc);
		return ResponseEntity.ok(response);
	}
	
	
	/*To Login into portal*/
	@PostMapping("/login")
	public boolean loginCheck(@RequestBody Login lc)
	{
		//Map<String,Boolean> response= new HashMap<>();
		//response.put("Logged In", Boolean.TRUE);
		Login lgc=lgRepo.findByCompanyNameAndPassword(lc.getCompanyName(),lc.getPassword());
//		ResponseEntity.ok(lgc);
//		return ResponseEntity.ok(response);
		
		if(lgc==null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	
}
