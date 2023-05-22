package org.example.controller;

import org.example.service.BookWriteService;

import java.util.Arrays;

import static org.example.entity.ConstructInjector.*;
import static org.example.input.InputView.getSearchChoice;

public enum Common {
    추가(1) {
        @Override
        public void exec() {
            bookWriteService().getNewBookInfo();
        }
    }, 삭제(2) {
        @Override
        public void exec() {
            bookReadService().getDeleteBookInfo();
        }
    }, 검색(3) {
        @Override
        public void exec() {
            SearchBook searchBook = SearchBook.findByIndex(getSearchChoice());
            searchBook.exec();
        }
    }, 대출(4) {
        @Override
        public void exec() {
            bookWriteService().checkOutBook();
        }
    }, 반납(5) {
        @Override
        public void exec() {
            bookWriteService().returnBook();
        }
    }, TOP10(6) {
        @Override
        public void exec() {
            bookReadService().findByTop10();
        }
    }, 종료(7) {
        @Override
        public void exec() {
            System.exit(0);
        }
    };

    public final int index;

    Common(int index){
        this.index = index;
    }

    public abstract void exec();

    public static Common findByIndex(int index) {
        return Arrays.stream(values())
                .filter(e -> e.index == index)
                .findFirst()
                .orElseThrow();
    }


}
