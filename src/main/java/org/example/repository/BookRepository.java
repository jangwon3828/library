package org.example.repository;

import org.example.entity.Book;
import org.example.input.InputView;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class BookRepository {
    private static BookRepository bookRepository = new BookRepository();
    private Connection con;
    private Statement st;

    private BookRepository() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?serverTimezon=UTC", "root", "1234");
            st = con.createStatement();
            System.out.println("데이터 베이스와 연결이 성공적으로 되었습니다");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BookRepository getInstance() {
        return bookRepository;
    }

    public List<Book> findByAuthor(String author) {
        String query = "select * from books where author = '" + author + "'";
        List<Book> books = new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String str = rs.getString("year_of_publication");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String[] s = str.split(" ");
                LocalDateTime dateTime = LocalDateTime.parse(s[0], formatter);
                Book book = new Book(Long.parseLong(rs.getString("book_id")),
                        rs.getString("bookname"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        Long.parseLong(rs.getString("borrowcount")),
                        rs.getString("ISBN_NO"),
                        dateTime,
                        Long.parseLong(rs.getString("count"))
                );
                books.add(book);
            }
        } catch (Exception e) {
            System.out.println("에러발생 findByAuthor");
        }

        return books;

    }
}
