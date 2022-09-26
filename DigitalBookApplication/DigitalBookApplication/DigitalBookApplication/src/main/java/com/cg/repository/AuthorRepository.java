package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.Book;

@Repository
public interface AuthorRepository extends JpaRepository<Book, Integer> {
    @Query("from Book where id=:id")
	Book getBookById(Integer id);

	Iterable<Book> findByTitle(String title);

	Book findAllByTitle(String title);
}