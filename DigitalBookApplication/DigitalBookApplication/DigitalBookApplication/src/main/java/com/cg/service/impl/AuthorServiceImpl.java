package com.cg.service.impl;

import java.util.Optional;
import javax.management.AttributeNotFoundException;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.DTO.PurchaseBookDTO;
import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.PurchaseBook;
import com.cg.model.User;
import com.cg.repository.AuthorListRepository;
import com.cg.repository.AuthorRepository;
import com.cg.repository.LoginRepository;
import com.cg.repository.PurchaseBookRepository;
import com.cg.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	 private AuthorListRepository repository;
	 private AuthorRepository authorRepository;
	 private LoginRepository loginrepository;
	 private PurchaseBookRepository purchasebookrepository;

	 public AuthorServiceImpl(AuthorRepository authorRepository, AuthorListRepository repository, LoginRepository loginrepository, PurchaseBookRepository purchasebookrepository) {
	        this.authorRepository = authorRepository;
	        this.repository=repository;
	        this.loginrepository=loginrepository;
	        this.purchasebookrepository=purchasebookrepository;
	    }
		 
	public Iterable<Book> getBooks(){
		return authorRepository.findAll();
	}
	
	public Book save(@Valid Book books) {
			authorRepository.save(books);
		return books; 
	}

	public Optional<Book> findBookById(Integer id) {
		return authorRepository.findById(id);
	}
	
	public Iterable<Author> getAuthors(){
		return repository.findAll();
	}

	public Author saveAuthor(@Valid Author authors) {
		return repository.save(authors);
	}

	public void deleteBook(Integer id) {
		authorRepository.deleteById(id);
	}

	 public ResponseEntity<Book> updateBook(Integer id, Book bookDetails)  throws AttributeNotFoundException {
		Book book = authorRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Product not found for this id :: " + id));

		book.setTitle(bookDetails.getTitle());
		book.setCategory(bookDetails.getCategory());
		book.setAuthor(bookDetails.getAuthor());
		book.setPrice(bookDetails.getPrice());
		book.setContent(bookDetails.getContent());
		book.setPublisher(bookDetails.getPublisher());
		book.setDate(bookDetails.getDate());
		final Book updatedBook = authorRepository.save(book);
		return ResponseEntity.ok(updatedBook);		
	}
		@SuppressWarnings("unchecked")
		public ResponseEntity<User> userlogin(@RequestBody User userdata) {
			User user = loginrepository.findByUsername(userdata.getUsername());
			if(user.getPassword().equals(userdata.getPassword()))
				return ResponseEntity.ok(user);
			return (ResponseEntity<User>) ResponseEntity.internalServerError();
		} 
	
		public User register(@Valid User user) {
			return loginrepository.save(user);	
		}

	@Override
	public Iterable<User> getUsers() {
		return loginrepository.findAll();
	}

	@Override
	public Optional<User> getUserByUsername(String username) {
		 return Optional.of(loginrepository.findByUsername(username));
	} 
	
	public Optional<Iterable<Book>> getBookByTitle(String title) {
		 return Optional.of(authorRepository.findByTitle(title));
	} 
	
	public void deleteUser(Integer id) {
		loginrepository.deleteById(id);
	}
	
	public String purachaseBook(PurchaseBookDTO purchaseBookDTO) {
        String Status="failure";
        Optional<Book> book = authorRepository.findById(purchaseBookDTO.getBookId());
        System.out.println("book=="+book);
        if(book.get()!=null) {
        int getuserId = loginrepository.getuserId(purchaseBookDTO.getUsername(),purchaseBookDTO.getUseremail());
            PurchaseBook purchaseBook = new PurchaseBook();
            purchaseBook.setBookId(purchaseBookDTO.getBookId());
            purchaseBook.setUserId(getuserId);
            purchasebookrepository.save(purchaseBook);
             Status="success";
        }else {
            Status="failure";
        }
        return Status;
    }
}