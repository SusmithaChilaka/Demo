package com.cg.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.User;
import com.cg.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/books")
public class AuthorController {
	
	@Autowired 
	AuthorService authorservice;

	@GetMapping
	public
	Iterable<Book> getBooks() {
		return authorservice.getBooks();
	}
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Integer id){
        return authorservice.findBookById(id);
    }
      
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	 public Integer saveBook(@Valid @RequestBody Book books) {
		authorservice.save(books);
		return books.getId();
	}
	
	@GetMapping("/authors")
	public
	Iterable<Author> getAuthors() {
		return authorservice.getAuthors();
	} 
	
	@PostMapping("/authors")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Integer saveAuthor(@Valid @RequestBody Author authors) {
		authorservice.saveAuthor(authors);
		return authors.getId();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
		authorservice.deleteBook(id);
		return new ResponseEntity<String>("Book deleted successfully!.", HttpStatus.OK);
	}
	
	/*  @ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
	    return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	} */
	
	@PostMapping("/login")
	public User userLogin(@RequestBody User userdata){
		authorservice.userlogin(userdata);
		return userdata;
	}
	
	@PostMapping("/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	 public Integer register(@Valid @RequestBody User user) {
		authorservice.register(user);
		return user.getId(); 
	}
}