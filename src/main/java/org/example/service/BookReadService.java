package org.example.service;

public class BookReadService {
    private static BookReadService bookReadService=new BookReadService();
    private BookReadService(){
    }

    public static BookReadService getInstance(){
        return bookReadService;
    }
}
