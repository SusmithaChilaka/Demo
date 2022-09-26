package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
	@Query(value="SELECT u.id FROM digitalbooksdb.users u where u.username=:username and u.email=:useremail",nativeQuery = true)
    int getuserId(String username, String useremail);



   User findByEmail(String emailId);
}