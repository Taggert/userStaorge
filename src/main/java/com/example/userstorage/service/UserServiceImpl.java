package com.example.userstorage.service;

import com.example.userstorage.model.User;
import com.example.userstorage.model.UserRequest;
import com.example.userstorage.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    @SneakyThrows
    public User create(UserRequest userRequest) {
        if(userRequest ==null){
            throw new Exception("Wrong data");
        }
        int idUser = repository.getAll().size()+1;

        User user = new User(idUser,userRequest.getFirstName(), userRequest.getLastName(), userRequest.getAge());
        if(repository.getByLastName(userRequest.getLastName()) != null){
            throw new Exception("User with such lastname already exists");
        }
        return repository.create(user);
    }

    @Override
    @SneakyThrows
    public User update(User user) {
        if(user ==null){
            throw new Exception("Wrong data");
        }
        return repository.update(user);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public User getByLastname(String lastname) {
        return repository.getByLastName(lastname);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);

    }
}