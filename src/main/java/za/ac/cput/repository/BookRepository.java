// BookRepository.java
package za.ac.cput.repository;

import za.ac.cput.domain.Book;
import java.util.*;

public class BookRepository implements IBookRepository {
    private static BookRepository repository = null;
    private Map<String, Book> bookMap;

    private BookRepository() {
        this.bookMap = new HashMap<>();
    }

    public static BookRepository getRepository() {
        if (repository == null) {
            repository = new BookRepository();
        }
        return repository;
    }

    @Override
    public Book create(Book book) {
        if (bookMap.containsKey(book.getIsbn())) {
            return null; // Prevent duplicate books
        }
        bookMap.put(book.getIsbn(), book);
        return book;
    }

    @Override
    public Book read(String isbn) {
        return bookMap.get(isbn);
    }

    @Override
    public Book update(Book book) {
        if (!bookMap.containsKey(book.getIsbn())) {
            return null;
        }
        bookMap.put(book.getIsbn(), book);
        return book;
    }

    @Override
    public boolean delete(String isbn) {
        return bookMap.remove(isbn) != null;
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(bookMap.values());
    }
}
