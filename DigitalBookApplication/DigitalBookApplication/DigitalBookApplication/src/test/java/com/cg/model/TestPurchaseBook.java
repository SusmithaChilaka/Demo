package com.cg.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;

public class TestPurchaseBook {
	
private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	PurchaseBook getBook() {
		PurchaseBook book = new PurchaseBook();
		book.setId(1);
		book.setBookId(1);
		book.setUserId(1);
		
		return book;
	}
	
	@Test
	void testBook() {
		PurchaseBook book = getBook();
		book.getId();
		book.getBookId();
		book.getUserId();
		Set<ConstraintViolation<PurchaseBook>> violations = validator.validate(book);
		assertTrue(violations.isEmpty());
	}
	
	int userData() {
		
		PurchaseBook book = new PurchaseBook();
		book.getId();
		book.getBookId();
		book.getUserId();
		return book.getId();
	}

}
