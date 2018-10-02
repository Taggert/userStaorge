package com.example.userstorage.service;

import com.example.userstorage.model.User;
import com.example.userstorage.model.UserRequest;
import com.example.userstorage.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    @SneakyThrows
    public User create(UserRequest userRequest) {
        if (userRequest == null) {
            throw new Exception("Wrong data");
        }
        int idUser = repository.getAll().size() + 1;

        User user = new User(idUser, userRequest.getFirstName(), userRequest.getLastName(), userRequest.getAge());
        if (getByLastname(userRequest.getLastName()) != null) {
            throw new Exception("User with such lastname already exists");
        }
        return repository.create(user);
    }

    @Override
    @SneakyThrows
    public User update(User user) {
        if (user == null) {
            throw new Exception("Wrong data");
        }
        if (repository.getAll().contains(user)) {
            return repository.update(user);
        }
        throw new Exception("No such user");
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    @SneakyThrows
    public User getById(Integer id) {
        if (id <= repository.getAll().size() && repository.getAll().get(id - 1) != null) {
            return repository.getById(id);
        }
        throw new Exception("No such user");
    }

    @Override
    public User getByLastname(String lastname) {
        if (lastname != null) {
            for (User u : repository.getAll()) {
                if (u.getLastName().equals(lastname)) {
                    return u;
                }
            }
        }
        return null;
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {
        if (id <= repository.getAll().size() && repository.getAll().get(id-1) != null) {
            repository.delete(id);
            return;
        }
        throw new Exception("No such user");
    }
}