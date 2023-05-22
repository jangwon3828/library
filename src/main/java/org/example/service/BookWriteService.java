package org.example.service;

import org.example.entity.Book;
import org.example.input.InputView;
import org.example.repository.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.input.InputView.*;
import static org.example.input.OutPutView.printMsg;

public class BookWriteService {

    private BookRepository bookRepository;
    private BookReadService bookReadService;

    public BookWriteService(BookRepository bookRepository, BookReadService bookReadService){
        this.bookRepository=bookRepository;
        this.bookReadService=bookReadService;
    }

    public void getNewBookInfo() {
        String bookName = inputString("책 제목을 입력해 주세요.");

        String author = inputString("저자명을 입력해 주세요.");

        String publisher = inputString("출판사를 입력해 주세요.");

        Long borrowCount = InputView.inputLong("해당 책의 누적 대출 횟수를 입력해 주세요.");

        String ISBN_NO = inputString("해당 책의 ISBN_NO 값을 입력해 주세요.");
        LocalDate year_of_publication = inputLocalDateTime("책 출간년도를 입력해 주세요. (format : yyyy-MM-dd)");
        Long count = InputView.inputLong("현재 도서관에 있는 책 권수를 입력해 주세요.");

        Book book = new Book(null, bookName, author, publisher, borrowCount, ISBN_NO, year_of_publication, count);

        bookRepository.insertBook(book);
    }


    public void checkOutBook() {


        List<Book> books = new ArrayList<>();
        Long index;
        while (books.size()==0) {
            index = howToFind();
            books = selectFind(index, books);
        }
        Long bookId = inputLong("대여할 책의 고유 번호를 입력해주세요");
        bookRepository.checkoutBook(bookId);

    }

    public void returnBook() {
        List<Book> books = null;
        Long index;
        while (books == null) {
            index = howToFind();
            books = selectFind(index, books);
        }
        Long bookId = inputLong("반납할 책의 고유 번호를 입력해주세요");
      bookRepository.returnBook(bookId);
    }


    private List<Book> selectFind(Long index, List<Book> books) {
        int idx= Math.toIntExact(index);
        switch (idx) {
            case 1: {
                books = bookReadService.findByAuthor();
            }
            break;
            case 2: {
                books = bookReadService.findByBookName();
            }
            break;
            case 3: {
                books = bookReadService.findByPublisher();
            }
            break;
        }
        return books;

    }
}
