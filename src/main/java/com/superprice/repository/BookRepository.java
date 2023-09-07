package com.superprice.repository;

import com.superprice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByNameContainingIgnoreCase(String name);
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);
}
