package org.example.service;


import org.example.entity.Book;
import org.example.input.InputView;
import org.example.repository.BookRepository;

import java.time.LocalDate;
import java.util.List;

import static org.example.input.OutPutView.printBooks;

public class BookReadService {
    private static BookReadService bookReadService=new BookReadService();
    private BookReadService(){
    }

    public static BookReadService getInstance(){
        return bookReadService;
    }

    private BookRepository bookRepository=BookRepository.getInstance();

    public void findByAuthor(){
        String author = InputView.inputString("찾으실 저자를 입력하세요");
        List<Book> books = bookRepository.findByAuthor(author);
        printBooks(books);
    }


    public void findByBookName(){
        String book = InputView.inputString("찾으실 책이름을 입력하세요");
        List<Book> books = bookRepository.findByBookName(book);
        printBooks(books);
    }

    public void findByPublisher(){
        String publisher = InputView.inputString("찾으실 출판사를 입력하세요");
        List<Book> books = bookRepository.findByPublisher(publisher);
        printBooks(books);
    }

    public void findByYear(){
        LocalDate localDate = InputView.inputLocalDateTime("몇년도 이후의 책을 검색하시겠습니까? ex)2022");
        List<Book> books = bookRepository.findByYear(localDate);
        printBooks(books);
    }


}
