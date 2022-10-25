package com.mjunction.Main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjunction.Main.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	

	Login findByCompanyNameAndPassword(String username, String password);
}
