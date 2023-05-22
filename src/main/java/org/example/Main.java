package org.example;


import org.example.entity.Book;
import org.example.input.InputView;
import org.example.repository.BookRepository;
import org.example.service.BookReadService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.example.input.OutPutView.init;


public class Main {

    public static void main(String[] args) {
        BookReadService bookRepository= BookReadService.getInstance();
        bookRepository.findByTop10();
    }



}