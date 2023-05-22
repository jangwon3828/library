package org.example.repository;

import org.example.entity.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
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
        return getBooks(query);

    }

    public List<Book> findByBookName(String author) {
        String query = "select * from books where author = '" + author + "'";
        return getBooks(query);
    }

    public List<Book> findByPublisher(String publisher) {
        String query = "select * from books where publisher  = '" + publisher + "'";
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


    public void insertBook(Book book){
        try{
            st.execute("insert into books(book_id, bookname, author, publisher, borrowcount, ISBN_NO, year_of_publication, count) values (null,'"+book.getBook_name()+"','"+book.getAuthor()+"','"+book.getPublisher()+"','"+book.getBorrow_count()+"','"+book.getISBN_NO()+"','"+book.getYear_of_publication()+"','"+book.getCount()+"');");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(st!=null)
                    st.close();
                if(con !=null)
                    con.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public List<Book> findByYear(LocalDate localDate) {


    }
}
