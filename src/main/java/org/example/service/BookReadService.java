package org.example.service;


import org.example.entity.Book;
import org.example.input.InputView;
import org.example.repository.BookRepository;

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
}
