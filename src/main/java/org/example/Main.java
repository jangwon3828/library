package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    static Connection conn = null;
    static Statement st = null;
    static{
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db01?serverTimezon=UTC","root","1234");
            st = conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try{
            ResultSet rs = st.executeQuery("show databases");
            while(rs.next()){
                System.out.println(rs.getString("Database"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(st!=null)
                    st.close();
                if(conn !=null)
                    conn.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }

    }
}