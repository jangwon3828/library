package org.example.repository;

import org.example.entity.Book;

public class BookRepository {
    private static BookRepository bookRepository=new BookRepository();
    private BookRepository(){
    }

    public BookRepository getInstance(){
        return bookRepository;
    }
}
