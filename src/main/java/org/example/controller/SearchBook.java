package org.example.controller;

import java.util.Arrays;

import static org.example.entity.ConstructInjector.bookReadService;

public enum SearchBook {

    책제목(1) {
        @Override
        public void exec() {
            bookReadService().findByBookName();
        }
    }, 저자(2) {
        @Override
        public void exec() {
            bookReadService().findByAuthor();
        }
    }, 출판사(3) {
        @Override
        public void exec() {
            bookReadService().findByPublisher();
        }
    }, 출판연도(4) {
        @Override
        public void exec() {
            bookReadService().findByYear();
        }
    }, 전체(5) {
        @Override
        public void exec() {
            bookReadService().findByAll();
        }
    };
    private final int index;

    SearchBook(int index) {
        this.index = index;
    }

    public static SearchBook findByIndex(int index) {
        return Arrays.stream(values())
                .filter(e -> e.index == index)
                .findFirst()
                .orElseThrow();
    }

    public abstract void exec();
}
