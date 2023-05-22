package org.example.repository;

import org.example.entity.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class BookRepository {
    private static BookRepository bookRepository=new BookRepository();
    private Connection con;
    private Statement st;
    private BookRepository(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?serverTimezon=UTC","root","1234");
            st = con.createStatement();
            System.out.println("데이터 베이스와 연결이 성공적으로 되었습니다");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static BookRepository getInstance(){
        return bookRepository;
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

}
