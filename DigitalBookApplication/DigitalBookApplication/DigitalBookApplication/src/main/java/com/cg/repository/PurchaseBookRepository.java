package com.cg.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.model.PurchaseBook;

@Repository
public interface PurchaseBookRepository extends JpaRepository<PurchaseBook, Integer>{
	List<PurchaseBook> findByUserId(int id);
}
