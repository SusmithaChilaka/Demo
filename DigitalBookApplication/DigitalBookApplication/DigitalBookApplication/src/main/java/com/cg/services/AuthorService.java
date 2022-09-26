package com.cg.services;

import java.util.Optional;
import javax.management.AttributeNotFoundException;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;

import com.cg.DTO.PurchaseBookDTO;
import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.User;

public interface AuthorService {

	Iterable<Book> getBooks();
	Optional<Book> findBookById(Integer id);
	Book save(@Valid Book books);
	Iterable<Author> getAuthors();
	Author saveAuthor(@Valid Author authors);
	void deleteBook(Integer id);
	ResponseEntity<Book> updateBook(Integer id, Book bookDetails)  throws AttributeNotFoundException;
	ResponseEntity<User> userlogin(User userdata);
	User register(@Valid User user);
	Iterable<User> getUsers();
	Optional<User> getUserByUsername(String username);
	Optional<Iterable<Book>> getBookByTitle(String title);
	void deleteUser(Integer id);
	String purachaseBook(PurchaseBookDTO purchaseBookDTO);
} 
