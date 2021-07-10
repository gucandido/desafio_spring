package com.desafio.desafiospring.services.user;

import com.desafio.desafiospring.dto.users.*;
import com.desafio.desafiospring.entities.user.User;
import com.desafio.desafiospring.exceptions.user.SameUserToFollow;
import com.desafio.desafiospring.exceptions.user.UserAlreadyFollowing;
import com.desafio.desafiospring.exceptions.user.UserNotFollowing;
import com.desafio.desafiospring.repositories.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private UserRepo repository;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepo repository) {
        this.repository = repository;
    }

    public UserInputDto create(UserInputDto user) {

        repository.save(user);

        return user;

    }

    public List<?> listAll(){
        List<UserOutputDto> output = new ArrayList<>();
        repository.findAll().forEach(x->output.add(UserOutputDto.classToDto(x)));
        return output;
    }

    public User findById(long id){
        return repository.findById(id);
    }

    public UserOutputDto findByIdOutput(long id){
        return UserOutputDto.classToDto(repository.findById(id));
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

    public String unfollow(long userId, long userIdToFollow){

        if(userId == userIdToFollow)
            throw new SameUserToFollow("Não é possível um usuário estar seguindo si mesmo");
        else if (!repository.isFollower(userId,userIdToFollow))
            throw new UserNotFollowing("Este usuário não segue este vendedor");
        else
            return repository.unfollow(userId, userIdToFollow);

    }

    public FollowersCountDto getFollowersCount(long id){

        User user = repository.findById(id);
        return new FollowersCountDto(user);

    }

    public FollowersDto getFollowersList(long id, Optional<String> order){

        User user = repository.findById(id);
        FollowersDto followers = new FollowersDto(user);

        orderListBy(followers.getFollowers(), order);

        return followers;

    }

    public FollowedDto getFollowedList(long id, Optional<String> order){

        User user = repository.findById(id);
        FollowedDto followed = new FollowedDto(user);

        orderListBy(followed.getFollowed(), order);

        return followed;

    }

    private void orderListBy(List<UserOutputDto> list, Optional<String> order){

        if(order.isPresent()){
            switch (order.get()){
                case "name_asc":
                    list.sort(Comparator.comparing(UserOutputDto::getUserName));
                    break;
                case "name_desc":
                    list.sort(Comparator.comparing(UserOutputDto::getUserName));
                    Collections.reverse(list);
                    break;
                default:
                    Collections.sort(list);

            }
        } else {
            Collections.sort(list);
        }

    }


}
