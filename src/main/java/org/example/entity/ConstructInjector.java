package org.example.entity;

import org.example.repository.BookRepository;
import org.example.service.BookReadService;
import org.example.service.BookWriteService;

public class ConstructInjector {
    private static BookReadService instanceBookReadService;
    private static BookWriteService instanceBookWriteService;
    private static BookRepository instanceBookRepository;

    public static BookRepository bookRepository(){
        if(instanceBookRepository==null){
            instanceBookRepository=new BookRepository();
        }
        return instanceBookRepository;
    }

    public static BookReadService bookReadService(){
        if (instanceBookReadService == null) {
            instanceBookReadService =  new BookReadService(bookRepository());
        }
        return instanceBookReadService;
    }

    public static BookWriteService bookWriteService(){
        if(instanceBookWriteService==null){
            instanceBookWriteService=new BookWriteService(bookRepository(), bookReadService());
        }
        return instanceBookWriteService;
    }
}
