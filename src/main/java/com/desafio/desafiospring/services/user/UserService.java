package com.desafio.desafiospring.services.user;

import com.desafio.desafiospring.dto.response.users.UserDto;
import com.desafio.desafiospring.entities.user.User;
import com.desafio.desafiospring.repositories.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo repository;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepo repository) {
        this.repository = repository;
    }

    public UserDto create(UserDto user) {

        repository.save(user);

        return user;

    }

    public List<?> listAll(){
        return repository.findAll();
    }

    public User findById(long id){
        return repository.findById(id);
    }

    public void delete(long id){
        repository.delete(id);
    }

    public String follow(long userId, long userIdToFollow){

        return repository.follow(userId, userIdToFollow);

    }



}
