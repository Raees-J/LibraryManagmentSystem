package za.ac.cput.domain;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private String genre;

    private Book() {}

    private Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.isbn = builder.isbn;
        this.publicationYear = builder.publicationYear;
        this.genre = builder.genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", genre='" + genre + '\'' +
                '}';
    }

    public static class Builder {
        private String title;
        private String author;
        private String isbn;
        private int publicationYear;
        private String genre;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder setPublicationYear(int publicationYear) {
            this.publicationYear = publicationYear;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder copy(Book book) {
            this.title = book.title;
            this.author = book.author;
            this.isbn = book.isbn;
            this.publicationYear = book.publicationYear;
            this.genre = book.genre;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
