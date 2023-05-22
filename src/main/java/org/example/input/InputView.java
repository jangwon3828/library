package org.example.input;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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

    public static LocalDateTime inputLocalDateTime(String msg) {
        System.out.println(msg);
        //yyyy-mm-dd로 입력하기
        String time = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.parse(time, formatter);
    }


}
