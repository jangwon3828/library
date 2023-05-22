package org.example.service;


import org.example.entity.Book;
import org.example.input.InputView;
import org.example.repository.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example.input.InputView.inputLocalDateTime;
import static org.example.input.InputView.inputString;
import static org.example.input.OutPutView.printBooks;

public class BookReadService {
    private BookRepository bookRepository;
    public BookReadService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

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

    public void getDeleteBookInfo(){
        String book_name = InputView.inputString("삭제할 책 제목을 입력해 주세요.");
        List<Book> books = bookRepository.findByBookName(book_name);
        if(books.size()>0){
            printBooks(books);
            Long book_id = InputView.inputLong("삭제할 책의 고유 번호를 입력해 주세요.");
            bookRepository.deleteBook(book_id);
        }
        else{
            System.out.println("책의 정보가 존재하지 않습니다.");
        }
    }
}
