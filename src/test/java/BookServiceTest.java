
package com.superprice.service;

import com.superprice.model.Book;
import com.superprice.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

	@Test
	public void testSearchByName() {
		Book book1 = new Book();
		book1.setName("Juice Book");
		Book book2 = new Book();
		book2.setName("Cook Book");

		when(bookRepository.findByNameContainingIgnoreCase("book")).thenReturn(asList(book1, book2));

		List<Book> books = bookService.searchByName("book");
		assertEquals(2, books.size());
		assertEquals("Juice Book", books.get(0).getName());
		assertEquals("Cook Book", books.get(1).getName());
	}

	@Test
	public void testSearchByPriceRange() {
		Book book1 = new Book();
		book1.setPrice(150.0);
		Book book2 = new Book();
		book2.setPrice(180.0);

		when(bookRepository.findByPriceBetween(100.0, 200.0)).thenReturn(asList(book1, book2));

		List<Book> books = bookService.searchByPriceRange(100.0, 200.0);
		assertEquals(2, books.size());
		assertEquals(150.0, books.get(0).getPrice());
		assertEquals(180.0, books.get(1).getPrice());
	}
}
