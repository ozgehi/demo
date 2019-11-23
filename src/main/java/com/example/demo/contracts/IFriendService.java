package com.example.demo.contracts;

import com.example.demo.model.Friend;
import org.springframework.data.repository.CrudRepository;



public interface IFriendService extends CrudRepository<Friend, Integer> {

    Iterable<Friend> findByFirstNameAndLastName(String name, String Surname);


}
