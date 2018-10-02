package com.example.userstorage.controller;

import com.example.userstorage.model.User;
import com.example.userstorage.model.UserRequest;
import com.example.userstorage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public User create(@RequestBody UserRequest userRequest) {
        return service.create(userRequest);

    }

    @PutMapping("/update")
    public  User update(@RequestBody User user){
        return service.update(user);
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/getuser/{id}")
    public User getById(@PathVariable ("id") Integer id){
        return service.getById(id);
    }

    @GetMapping("/getbylastname/{lastname}")
    public User getById(@PathVariable ("lastname") String lastname){
        return service.getByLastname(lastname);
    }

    @DeleteMapping("/delete/{id}")
    public  void delete(@PathVariable ("id") Integer id){
         service.delete(id);
    }


}