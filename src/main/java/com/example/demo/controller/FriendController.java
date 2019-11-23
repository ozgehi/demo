package com.example.demo.controller;


import com.example.demo.contracts.IFriendService;
import com.example.demo.model.Friend;
import com.example.demo.util.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.bind.ValidationException;
import java.util.Optional;

@RestController
public class FriendController {

    @Autowired
    IFriendService friendService;


    @GetMapping("/friend")
    Iterable<Friend> read() {
        return friendService.findAll();
    }

    @PostMapping("/friend")
    Friend create(@RequestBody Friend friend) throws ValidationException {
        if(friend.getFirstName() != null || friend.getLastName() != null )
        return friendService.save(friend);
        else
            throw new ValidationException("Request not completed!");
    }


    @DeleteMapping("/friend/{id}")
    void delete(@PathVariable Integer id) {
        friendService.deleteById(id);
    }

    @GetMapping("/friend/{id}")
    Optional<Friend> findById(@PathVariable Integer id){
        return friendService.findById(id);
    }

    @GetMapping("/friend/search")
    Iterable<Friend> findByQuery(@RequestParam String first ,
                                 @RequestParam String last){

        return friendService.findByFirstNameAndLastName(first,last);
    }
    //http://localhost:8080/friend/search?first=Özge&last=Hızal
}




