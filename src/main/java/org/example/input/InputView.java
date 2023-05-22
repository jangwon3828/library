package org.example.input;

import java.time.LocalDate;
import java.time.LocalDateTime;
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


}
