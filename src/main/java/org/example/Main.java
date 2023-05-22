package org.example;

import java.sql.ResultSet;

import static org.example.Connection.conn;
import static org.example.Connection.st;

public class Main {

    public static void main(String[] args) {
        connectDB();
        init();
        while (true){

        }
    }

    private static void init() {
        System.out.println("반갑습니다");
        System.out.println("");
    }

    private static void connectDB() {
        try{
            ResultSet rs = st.executeQuery("show databases");
            System.out.println("데이베이스 연결이 성공적으로 되었습니다.");
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