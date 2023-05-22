package org.example.input;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static org.example.input.OutPutView.printMsg;

public class InputView {
    private final static Scanner sc = new Scanner(System.in);

    public static String inputString(String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }

    public static Long inputLong(String msg) {
        System.out.println(msg);
        return sc.nextLong();
    }
    public static Integer inputInteger(String msg){
        System.out.println(msg);
        return sc.nextInt();
    }


    public static Long howToFind() {
        printMsg("1.저자로 검색하기");
        printMsg("2.책이름으로 검색하기");
        printMsg("3.출판사로 검색하기");
        Long index = InputView.inputLong("검색방법을 입력해주세요");
        return index;
    }

    public static LocalDate inputLocalDateTime(String msg) {
        System.out.println(msg);
        //yyyy-mm-dd로 입력하기
        String time = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(time, formatter);
    }

    public static Integer getChoice(){
        System.out.println("1. 도서 추가");
        System.out.println("2. 도서 삭제");
        System.out.println("3. 도서 검색");
        System.out.println("4. 도서 대출");
        System.out.println("5. 도서 반납");
        System.out.println("6. 이번 달 TOP10 도서");
        System.out.println("7. 종료");

        return sc.nextInt();
    }

    public static Integer getSearchChoice(){
        System.out.println("1. 책 이름 검색");
        System.out.println("2. 저자 검색");
        System.out.println("3. 출판사 검색");
        System.out.println("4. 특정 연도 이후 출간 책 검색");
        System.out.println("5. 모든 책 검색");
        System.out.println("6. 처음 화면으로 돌아가기");

        return sc.nextInt();
    }


}
