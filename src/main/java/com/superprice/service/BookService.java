package com.superprice.service;

import com.superprice.model.Book;
import com.superprice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.superprice.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository BookRepository;

    public List<Book> getAllBooks() {
        return BookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return BookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book Book) {
        return BookRepository.save(Book);
    }

    public void deleteBook(Long id) {
        BookRepository.deleteById(id);
    }

	public Book updateBook(Long id, Book BookDetails) {
		Book Book = BookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

		Book.setName(BookDetails.getName());
		Book.setPrice(BookDetails.getPrice());
		return BookRepository.save(Book);
	}

	public List<Book> searchByName(String name) {
        return BookRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Book> searchByPriceRange(Double minPrice, Double maxPrice) {
        return BookRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
