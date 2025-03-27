package za.ac.cput.factory;

import za.ac.cput.domain.Book;
import za.ac.cput.util.Helper;

public class BookFactory {

    public static Book createBook(String title, String author, String isbn, int publicationYear, String genre) {
        if (Helper.isNullOrEmpty(title) ||
            Helper.isNullOrEmpty(author) ||
            Helper.isNullOrEmpty(isbn) ||
            Helper.isNullOrEmpty(genre) ||
            publicationYear <= 0) {
            return null; // Or throw an IllegalArgumentException, depending on your error handling preference.
        }

        return new Book.Builder()
                .setTitle(title)
                .setAuthor(author)
                .setIsbn(isbn)
                .setPublicationYear(publicationYear)
                .setGenre(genre)
                .build();
    }
}
