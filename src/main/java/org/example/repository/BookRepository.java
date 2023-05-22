package org.example.repository;

import org.example.entity.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class BookRepository {
    private static BookRepository bookRepository=new BookRepository();
    private Connection con;
    private Statement st;
    private BookRepository(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db01?serverTimezon=UTC","root","1234");
            st = con.createStatement();
            System.out.println("데이터 베이스와 연결이 성공적으로 되었습니다");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public BookRepository getInstance(){
        return bookRepository;
    }

}
