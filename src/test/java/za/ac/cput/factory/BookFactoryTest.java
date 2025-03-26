package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Book;

import static org.junit.jupiter.api.Assertions.*;

public class BookFactoryTest {

    @Test
    public void testCreateBook_ValidBook() {
        Book book = BookFactory.createBook("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "978-0345391803", 1979, "Science Fiction");

        assertNotNull(book);
        assertEquals("The Hitchhiker's Guide to the Galaxy", book.getTitle());
        assertEquals("Douglas Adams", book.getAuthor());
        assertEquals("978-0345391803", book.getIsbn());
        assertEquals(1979, book.getPublicationYear());
        assertEquals("Science Fiction", book.getGenre());
    }

    @Test
    public void testCreateBook_InvalidBook() {
        Book book = BookFactory.createBook("", "Invalid Author", "Invalid ISBN", -2000, "");

        assertNull(book); // Assuming your BookFactory returns null for invalid input
    }

    @Test
    public void testCreateBook_AnotherValidBook() {
        Book book = BookFactory.createBook("Pride and Prejudice", "Jane Austen", "978-0141439518", 1813, "Classic");

        assertNotNull(book);
        assertEquals("Pride and Prejudice", book.getTitle());
        assertEquals("Jane Austen", book.getAuthor());
        assertEquals("978-0141439518", book.getIsbn());
        assertEquals(1813, book.getPublicationYear());
        assertEquals("Classic", book.getGenre());
    }
}
