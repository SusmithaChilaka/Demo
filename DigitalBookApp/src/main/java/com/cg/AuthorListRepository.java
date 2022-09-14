package com.cg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Author;

@Repository
public interface AuthorListRepository extends JpaRepository<Author, Integer>{

}
