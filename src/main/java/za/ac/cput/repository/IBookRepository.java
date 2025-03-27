// IBookRepository.java
package za.ac.cput.repository;

import za.ac.cput.domain.Book;
import java.util.List;

public interface IBookRepository {
    Book create(Book book);
    Book read(String isbn); // Assuming ISBN is the unique identifier
    Book update(Book book);
    boolean delete(String isbn);
    List<Book> getAll();
}
