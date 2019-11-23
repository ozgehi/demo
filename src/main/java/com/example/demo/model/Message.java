package com.example.demo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Message {
    private String content;
    private Integer returnCode;

    public Message(String content, Integer returnCode) {
        this.content = content;
        this.returnCode = returnCode;
    }
}
