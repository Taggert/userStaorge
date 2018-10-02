package com.example.userstorage.service;

import com.example.userstorage.model.User;
import com.example.userstorage.model.UserRequest;

import java.util.List;

public interface UserService {

    User create(UserRequest user);
    User update(User user);
    List<User> getAll();
    User getById(Integer id);
    User getByLastname(String lastname);
    void delete(Integer id);


}