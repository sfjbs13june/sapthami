package com.sapthami.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiverController {
    private static final Logger logger= LoggerFactory.getLogger(ReceiverController.class);
    @GetMapping("/receive")
    public String receiveData(){
        logger.info("receiver send");
        return "receive data from receiver";
    }
}
