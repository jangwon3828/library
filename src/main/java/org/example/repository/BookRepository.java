package org.example.repository;

import org.example.entity.Book;
import org.example.input.OutPutView;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.example.input.OutPutView.printMsg;


public class BookRepository {
    private static Connection con;
    private static Statement st;

    public BookRepository(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?serverTimezon=UTC", "root", "1234");
            st = con.createStatement();
            System.out.println("데이터 베이스와 연결이 성공적으로 되었습니다");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Book> findByAuthor(String author) {
        String query = "select * from books where author = '" + author + "'";
        return getBooks(query);

    }

    public List<Book> findByBookName(String book_name) {
        String query = "select * from books where bookname = '" + book_name + "'";
        return getBooks(query);
    }

    public List<Book> findByPublisher(String publisher) {
        String query = "select * from books where publisher  = '" + publisher + "'";
        return getBooks(query);
    }

    public List<Book> findByYear(LocalDate localDate) {
        String query = "select * from books where year_of_publication > '" + localDate + "'";
        return getBooks(query);

    }

    public List<Book> findByAll() {
        String query = "select * from books";
        return getBooks(query);

    }

    private List<Book> getBooks(String query) {
        List<Book> books = new ArrayList<>();
        try {
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String str = rs.getString("year_of_publication");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String[] s = str.split(" ");
                LocalDate dateTime = LocalDate.parse(s[0], formatter);
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

    private Book getBook(String query) {
        Book book=new Book();
        try {
            ResultSet rs = st.executeQuery(query);
            String str = rs.getString("year_of_publication");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String[] s = str.split(" ");
            LocalDate dateTime = LocalDate.parse(s[0], formatter);
            book = new Book(Long.parseLong(rs.getString("book_id")),
                    rs.getString("bookname"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    Long.parseLong(rs.getString("borrowcount")),
                    rs.getString("ISBN_NO"),
                    dateTime,
                    Long.parseLong(rs.getString("count"))
            );
            return book;

        } catch (Exception e) {
            System.out.println("에러발생 findByAuthor");
        }
        return book;

    }


    public void insertBook(Book book){
        try{
            st.execute("insert into books(book_id, bookname, author, publisher, borrowcount, ISBN_NO, year_of_publication, count) values (null,'"+book.getBook_name()+"','"+book.getAuthor()+"','"+book.getPublisher()+"','"+book.getBorrow_count()+"','"+book.getISBN_NO()+"','"+book.getYear_of_publication()+"','"+book.getCount()+"');");
            OutPutView.printMsg("도서 등록이 완료되었습니다.");
        }catch(Exception e){
            System.out.println("에러발생 insertBook");
        }
    }

    public void deleteBook(Long book_id){
        try{
            st.execute("DELETE FROM books WHERE book_id='"+ book_id +"'");
            OutPutView.printMsg("도서 삭제가 완료되었습니다.");
        }catch(Exception e){
            System.out.println("에러발생 deleteBook");
        }
    }
  
     public void checkoutBook(Long book_id) {
        int bookId= Math.toIntExact(book_id);
        String query = "update books set borrowcount = borrowcount +1 , count = count-1 where book_id= " + bookId  ;
        try {
            st.execute(query);
            printMsg("책을 빌렸습니다");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void returnBook(Long book_id) {
        String query = "update books set count = count+1 where book_id= " + book_id ;
        try {
            st.execute(query);
            printMsg("책을 반납하였습니다.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
