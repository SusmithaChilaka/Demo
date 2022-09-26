package com.cg.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.jupiter.api.Test;

public class TestUser {
	
private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	User getUser() {
		User user = new User();
		user.setId(1);
		user.setMobilenumber(0);
		user.setPassword("");
		user.setUsername("");
		user.setEmail("");
		user.setRole("");
		return user;
	}
	
	@Test
	void testUser() {
		User user = getUser();
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		assertTrue(violations.isEmpty());
	}
	
	String userData() {
		
		User user = new User();
		user.getId();
		user.getMobilenumber();
		user.getEmail();
		user.getUsername();
		user.getPassword();
		return user.getUsername();
	}
}