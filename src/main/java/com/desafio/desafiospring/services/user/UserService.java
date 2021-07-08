package com.desafio.desafiospring.services.user;

import com.desafio.desafiospring.dto.users.FollowersCountDto;
import com.desafio.desafiospring.dto.users.UserDto;
import com.desafio.desafiospring.entities.user.User;
import com.desafio.desafiospring.exceptions.SameUserToFollow;
import com.desafio.desafiospring.exceptions.UserAlreadyFollowing;
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

        if(userId == userIdToFollow)
            throw new SameUserToFollow("Não é possível um usuário seguir a si mesmo");
        else if (repository.isFollower(userId,userIdToFollow))
            throw new UserAlreadyFollowing("Este usuário já é seguidor deste vendedor");
        else
            return repository.follow(userId, userIdToFollow);

    }

    public FollowersCountDto getFollowersCount(long id){

        User user = repository.findById(id);

        return new FollowersCountDto(user);

    }

}
