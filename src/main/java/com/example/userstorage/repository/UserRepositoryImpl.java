package com.example.userstorage.repository;

import com.example.userstorage.model.User;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();


    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    @SneakyThrows
    public User update(User user) {
            users.set(user.getId() - 1, user);
            return user;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    @SneakyThrows
    public User getById(Integer id) {
        return users.get(id - 1);
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {
        int index = id-1;
        users.remove(index);
    }


}