package com.cg.controller;

import java.util.Optional;
import javax.management.AttributeNotFoundException;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.DTO.PurchaseBookDTO;
import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.services.AuthorService;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/books")
public class AuthorController {
	

	 private AuthorService authorservice;

	    public AuthorController(AuthorService authorservice) {
	        this.authorservice = authorservice;
	    } 

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
	void deleteBook(@PathVariable("id") Integer id) {
		authorservice.deleteBook(id);
	} 
	
	
	 @PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Integer id,
			 @RequestBody Book bookDetails) throws AttributeNotFoundException {
		return authorservice.updateBook(id, bookDetails);
	}
	 
		@GetMapping("/search/{title}")
	    public Optional<Iterable<Book>> getBookByTitle(@PathVariable String title){
	        return authorservice.getBookByTitle(title);
	    } 
		
		@PostMapping("/buy")
		   public String purachaseBook(@RequestBody PurchaseBookDTO purchaseBookDTO) {
		    return authorservice.purachaseBook(purchaseBookDTO);
		       
		   }
	 
	/*  @ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
	    return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	} */
}