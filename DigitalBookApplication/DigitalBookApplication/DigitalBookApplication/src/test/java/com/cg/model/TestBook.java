package com.cg.model;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;

public class TestBook {
	
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	Book getBook() {
		Book book = new Book();
		book.setId(1);
		book.setTitle("");
		book.setCategory(null);
		book.setPrice(0);
		book.setAuthor("");
		book.setPublisher("");
    	book.setDate(null );
		book.setContent("");
		return book;
	}
	
	@Test
	void testBook() {
		Book book = getBook();
		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		assertFalse(violations.isEmpty());
	}

}
