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
        if (users.contains(user)) {
            users.set(user.getId() - 1, user);
            return user;
        }
        throw new Exception("No such user");
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    @SneakyThrows
    public User getById(Integer id) {
        if (users.get(id - 1) != null) {
            return users.get(id - 1);
        }
        throw new Exception("No such user");
    }

    @Override
    @SneakyThrows
    public User getByLastName(String lastname) {
        if (lastname != null) {
            for (User u : users) {
                if(u.getLastName().equals(lastname)){
                    return u;
                }
            }
        }
        return null;
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {
        if (users.get(id) != null) {
            users.remove(users.get(id));
        }
        throw new Exception("No such user");

    }


}