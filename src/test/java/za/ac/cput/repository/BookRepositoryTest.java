package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.BookFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {

    private IBookRepository repository;
    private Book book;

    @BeforeEach
    void setUp() {
        repository = BookRepository.getRepository();
        book = BookFactory.createBook("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "978-0345391803", 1979, "Science Fiction");
        repository.create(book);
    }

    @Test
    void testCreate() {
        assertNotNull(repository.read("978-0345391803"));
    }

    @Test
    void testRead() {
        Book readBook = repository.read("978-0345391803");
        assertEquals(book.getIsbn(), readBook.getIsbn());
    }

    @Test
    void testUpdate() {
        Book updatedBook = BookFactory.createBook("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "978-0345391803", 1980, "Science Fiction");
        repository.update(updatedBook);
        assertEquals(1980, repository.read("978-0345391803").getPublicationYear());
    }

    @Test
    void testDelete() {
        assertTrue(repository.delete("978-0345391803"));
        assertNull(repository.read("978-0345391803"));
    }

    @Test
    void testGetAll() {
        List<Book> books = repository.getAll();
        assertFalse(books.isEmpty());
    }
}
