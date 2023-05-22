package org.example.entity;

import java.time.LocalDate;
public class Book {
    private Long book_id;
    private String bookName;
    private String author;
    private String publisher;
    private Long borrowCount;
    private String ISBN_NO;
    private LocalDate year_of_publication;
    private Long count;

    public Book(Long  book_id,String bookName, String author, String publisher, Long borrowCount, String ISBN_NO, LocalDate year_of_publication, Long count) {
        this.book_id=book_id;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.borrowCount = borrowCount;
        this.ISBN_NO = ISBN_NO;
        this.year_of_publication = year_of_publication;
        this.count = count;
    }

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

    public LocalDate getYear_of_publication() {
        return year_of_publication;
    }

    public Long getCount() {
        return count;
    }
}
