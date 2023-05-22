package org.example;

import org.example.entity.Book;
import org.example.input.InputView;
import org.example.repository.BookRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        init();
        BookRepository bookRepository=BookRepository.getInstance();
        LocalDate localDateTime = InputView.inputLocalDateTime("dpsdajfk");

        System.out.println(localDateTime);
//
//        printBooks(books);
    }

    private static void printBooks(List<Book> books) {
        for(Book book: books){
            System.out.println(book.getBook_id());
            System.out.println(book.getBookName());
            System.out.println(book.getPublisher());
            System.out.println(book.getISBN_NO());
            System.out.println(book.getCount());
            System.out.println(book.getBorrowCount());
            System.out.println(book.getYear_of_publication());
            System.out.println(book.getAuthor());
            System.out.println();
            System.out.println();
        }
    }

    private static void init() {
        System.out.println("반갑습니다");
        System.out.println("");
    }


}