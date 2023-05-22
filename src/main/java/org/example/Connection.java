package org.example;

import java.sql.DriverManager;
import java.sql.Statement;

public class Connection {
    static java.sql.Connection conn = null;
    static Statement st = null;
    static{
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db01?serverTimezon=UTC","root","1234");
            st = conn.createStatement();
            System.out.println("데이터 베이스와 연결이 성공적으로 되었습니다");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
