package org.example;

import org.example.service.BookWriteService;

public class Main {

    public static void main(String[] args) {
        init();
        BookWriteService bookWriteService = BookWriteService.getInstance();

        while (true){
            bookWriteService.getNewBookInfo();
            break;
        }
    }

    private static void init() {
        System.out.println("반갑습니다");
        System.out.println("");
    }
}