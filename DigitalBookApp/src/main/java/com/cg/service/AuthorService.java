package com.cg.service;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.AuthorListRepository;
import com.cg.AuthorRepository;
import com.cg.model.Author;
import com.cg.model.Book;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	AuthorListRepository repository;
	
	
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
}