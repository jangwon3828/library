package org.example.entity;

import org.example.repository.BookRepository;

import java.time.LocalDateTime;

public class Book {
    private Long book_id;
    private String bookName;
    private String author;
    private String publisher;
    private Long borrowCount;
    private String ISBN_NO;
    private LocalDateTime year_of_publication;
    private Long count;

    public Long getBook_id() {
        return book_id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public Long getBorrowCount() {
        return borrowCount;
    }

    public String getISBN_NO() {
        return ISBN_NO;
    }

    public LocalDateTime getYear_of_publication() {
        return year_of_publication;
    }

    public Long getCount() {
        return count;
    }
}
