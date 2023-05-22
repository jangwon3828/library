package org.example.input;

import org.example.entity.Book;

import java.util.List;

public class OutPutView {
    public static void init() {
        System.out.println("★★★★★★★★★★★★★★★★★도서관리 프로그램★★★★★★★★★★★★★★★★★");
        System.out.println("★                                                       ★");
        System.out.println("★                                                       ★");
        System.out.println("★                     김희아, 장원진                      ★");
        System.out.println("★                                                       ★");
        System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
    }

    public static void printBooks(List<Book> books) {
        int n = 1;
        books.stream().forEach(book -> {
                    System.out.println("책의 고유 번호 : "+book.getBook_id());
                    System.out.println("  제목 : " + book.getBook_name());
                    System.out.println("  저자 : " + book.getAuthor());
                    System.out.println("  출판사 : " + book.getPublisher());
                    System.out.println("  ISBN : " + book.getISBN_NO());
                    System.out.println("  누적대여 횟수 : " + book.getBorrow_count());
                    System.out.println("  책 출판일 : " + book.getYear_of_publication());
                    System.out.println("  책의 개수 : " + book.getCount());

                }
        );
    }
}
