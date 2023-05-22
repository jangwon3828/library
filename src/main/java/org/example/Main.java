package org.example;


import org.example.controller.Common;

import static org.example.input.InputView.getChoice;
import static org.example.input.OutPutView.init;


public class Main {

    public static void main(String[] args) {
        init();
        while(true){
            Common common = Common.findByIndex(getChoice());
            common.exec();
        }
    }



}