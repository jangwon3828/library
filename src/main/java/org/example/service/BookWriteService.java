package org.example.service;

import org.example.entity.Book;
import org.example.repository.BookRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BookWriteService {
    private static BookWriteService bookWriteService=new BookWriteService();
    private BookWriteService(){
    }

    public static BookWriteService getInstance(){
        return bookWriteService;
    }

    public void getNewBookInfo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("책 제목");
        String bookName = sc.nextLine();

        System.out.println("저자명");
        String author = sc.nextLine();

        System.out.println("출판사명");
        String publisher = sc.nextLine();

        System.out.println("대출 횟수");
        Long borrowCount = Long.valueOf(sc.nextLine());


        System.out.println("ISBN_NO");
        String ISBN_NO=sc.nextLine();

        System.out.println("발간연도 yyyy-MM-dd");

        String str_publication= sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate year_of_publication = LocalDate.parse(str_publication, formatter);

        System.out.println("잔여 책 수");
        Long count = Long.valueOf(sc.nextLine());

        Book book = new Book(null, bookName, author, publisher, borrowCount, ISBN_NO, year_of_publication, count);

        BookRepository br = BookRepository.getInstance();
        br.insertBook(book);
    }
}
