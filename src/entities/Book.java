package entities;

import enums.BookGenre;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String title;
    private BookGenre genre;
    private LocalDate publishDate;
    private Boolean available;
    private Author author;

    public Book() {}

    public Book(String title, BookGenre genre, LocalDate publishDate,Author author) {
        this.title = title;
        this.genre = genre;
        this.publishDate = publishDate;
        this.author = author;
        this.available = true;
    }

    public void lend() {
        if (!available) {
            throw new RuntimeException("O livro " + title + "já está emprestado.");
        }

        available = false;
    }

    public void returnBook() {
        if (available) {
            throw new RuntimeException("O livro " + title + "não está emprestado");
        }
        available = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return title +
                " por " +
                author +
                " publicado em " + publishDate.format(fmt);
    }
}
