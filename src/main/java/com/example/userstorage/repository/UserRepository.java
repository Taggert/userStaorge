package com.example.userstorage.repository;

import com.example.userstorage.model.User;

import java.util.List;

public interface UserRepository {

    User create(User user);
    User update(User user);
    List<User> getAll();
    User getById(Integer id);
    User getByLastName(String lastname);
    void delete(Integer id);

}