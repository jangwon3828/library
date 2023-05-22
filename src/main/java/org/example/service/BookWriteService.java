package org.example.service;

import org.example.entity.Book;
import org.example.input.InputView;
import org.example.input.OutPutView;
import org.example.repository.BookRepository;

import java.time.LocalDate;

import static org.example.input.InputView.inputLocalDateTime;
import static org.example.input.InputView.inputString;

public class BookWriteService {
    private static BookWriteService bookWriteService=new BookWriteService();
    private BookWriteService(){
    }

    public static BookWriteService getInstance(){
        return bookWriteService;
    }

    public void getNewBookInfo(){
        String bookName = inputString("책 제목을 입력해 주세요.");
        String author = inputString("저자명을 입력해 주세요.");
        String publisher = inputString("출판사를 입력해 주세요.");
        Long borrowCount = InputView.inputLong("해당 책의 누적 대출 횟수를 입력해 주세요.");
        String ISBN_NO = inputString("해당 책의 ISBN_NO 값을 입력해 주세요.");
        LocalDate year_of_publication = inputLocalDateTime("책 출간년도를 입력해 주세요. (format : yyyy-MM-dd)");
        Long count = InputView.inputLong("현재 도서관에 있는 책 권수를 입력해 주세요.");

        Book book = new Book(null, bookName, author, publisher, borrowCount, ISBN_NO, year_of_publication, count);

        BookRepository br = BookRepository.getInstance();
        br.insertBook(book);
        OutPutView.printMsg("도서 등록이 완료되었습니다.");
    }
}
