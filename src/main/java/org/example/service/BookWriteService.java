package org.example.service;

public class BookWriteService {


    private static BookWriteService bookWriteService=new BookWriteService();
    private BookWriteService(){
    }

    public BookWriteService getInstance(){
        return bookWriteService;
    }
}
