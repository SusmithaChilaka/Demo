package com.cg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, String>{

	User findByUsername(String username);

}