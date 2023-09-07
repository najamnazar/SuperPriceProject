import com.superprice.SuperPriceApplication;
import com.superprice.model.Book;
import com.superprice.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ContextConfiguration(classes = SuperPriceApplication.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository productRepository;

    @Test
    public void testSaveBook() {
        Book product = new Book();
        product.setName("Test Book");
        product.setPrice(100.00);

        Book savedBook = productRepository.save(product);

        assertThat(savedBook).isNotNull();
        assertThat(savedBook.getId()).isNotNull();
    }

    @Test
    public void testFindBookById() {
        Book product = new Book();
        product.setName("Test Book");
        product.setPrice(100.00);

        Book savedBook = productRepository.save(product);

        Optional<Book> foundBook = productRepository.findById(savedBook.getId());

        assertThat(foundBook).isPresent();
        assertThat(foundBook.get().getName()).isEqualTo("Test Book");
        assertThat(foundBook.get().getPrice()).isEqualTo(100.00);
    }
}

