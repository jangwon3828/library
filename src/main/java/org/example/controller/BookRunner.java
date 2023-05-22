package org.example.controller;

import org.example.input.OutPutView;
import org.example.service.BookReadService;
import org.example.service.BookWriteService;

import static org.example.input.InputView.getChoice;
import static org.example.input.InputView.getSearchChoice;
import static org.example.input.OutPutView.init;
import static org.example.input.OutPutView.printMsg;

public class BookRunner {
    BookWriteService ws;
    BookReadService rs;

    public BookRunner(){
        ws = BookWriteService.getInstance();
        rs = BookReadService.getInstance();
    }
    public void run(){
        init();

        while(true){
            switch(getChoice()){
                case 1:
                    ws.getNewBookInfo();
                    break;
                case 2:
                    rs.getDeleteBookInfo();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    ws.checkOutBook();
                    break;
                case 5:
                    ws.returnBook();
                    break;
                case 6:
                    rs.findByTop10();
                    break;
                case 7:
                    System.exit(0);
                default:
                    printMsg("잘못 입력하였습니다. 다시 입력해 주세요.");
            }
        }
    }

    private void searchBook(){
        switch(getSearchChoice()){
            case 1:
                rs.findByBookName();
                break;
            case 2:
                rs.findByAuthor();
                break;
            case 3:
                rs.findByPublisher();
                break;
            case 4:
                rs.findByYear();
                break;
            case 5:
                rs.findByAll();
                break;
            default:
                break;
        }
    }
}
