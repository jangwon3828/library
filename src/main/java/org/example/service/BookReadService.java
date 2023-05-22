package org.example.service;

import org.example.repository.BookRepository;

public class BookReadService {
    private static BookReadService bookReadService=new BookReadService();
    private BookReadService(){
    }

    public BookReadService getInstance(){
        return bookReadService;
    }
}
