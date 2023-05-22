package org.example.service;

import org.example.entity.Book;
import org.example.repository.BookRepository;

import java.util.List;

public class BookReadService {
    private static BookReadService bookReadService=new BookReadService();
    private BookReadService(){
    }

    public BookReadService getInstance(){
        return bookReadService;
    }

    private BookRepository bookRepository=BookRepository.getInstance();

//    public List<Book> findByAuthor(){
//
//        List<Book> books = bookRepository.findByAuthor("저자");
//    }
}
