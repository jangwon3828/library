package org.example.service;


import org.example.entity.Book;
import org.example.repository.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example.input.InputView.inputLocalDateTime;
import static org.example.input.InputView.inputString;
import static org.example.input.OutPutView.printBooks;

public class BookReadService {
    private static BookReadService bookReadService=new BookReadService();
    private BookReadService(){
    }

    public static BookReadService getInstance(){
        return bookReadService;
    }

    private BookRepository bookRepository=BookRepository.getInstance();

    public  List<Book> findByAuthor(){
        String author = inputString("찾으실 저자를 입력하세요");
        List<Book> books = bookRepository.findByAuthor(author);
        printBooks(books);
        return books;
    }


    public  List<Book> findByBookName(){
        String book = inputString("찾으실 책이름을 입력하세요");
        List<Book> books = bookRepository.findByBookName(book);
        printBooks(books);
        return books;
    }

    public  List<Book> findByPublisher(){
        String publisher = inputString("찾으실 출판사를 입력하세요");
        List<Book> books = bookRepository.findByPublisher(publisher);
        printBooks(books);
        return books;
    }

    public  List<Book> findByYear(){
        LocalDate localDate = inputLocalDateTime("몇년도 이후의 책을 검색하시겠습니까? ex)2022-01-01");
        List<Book> books = bookRepository.findByYear(localDate);
        printBooks(books);
        return books;
    }

    public  List<Book> findByAll(){
        List<Book> books = bookRepository.findByAll();
        printBooks(books);
        return books;
    }

    public  List<Book> findByTop10(){
        List<Book> books = bookRepository.findByAll();
        Collections.sort(books);
        if(books.size()<10){
            printBooks(books);
        }else {
            List<Book> top10=new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                top10.add(books.get(i));
            }
            printBooks(top10);
        }
        return books;

    }

}
