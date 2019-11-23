package com.example.demo.controller;
import com.example.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {

    @ResponseBody
    @GetMapping("/message")
    public Message send () {
        return new Message("First Message",345);
    }
    @ResponseBody
    @PostMapping("/message")
    Message echo (@RequestBody  Message message){
        return message;
    }


}
