package com.superprice.controller;

import com.superprice.model.Book;
import com.superprice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService BookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return BookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return BookService.getBookById(id);
    }

    @PostMapping
    public Book saveBook(@RequestBody Book Book) {
        return BookService.saveBook(Book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        BookService.deleteBook(id);
    }

	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book BookDetails) {
		return BookService.updateBook(id, BookDetails);
	}
}
