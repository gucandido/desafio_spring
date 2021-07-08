package com.desafio.desafiospring.repositories.user;

import com.desafio.desafiospring.dto.response.users.UserDto;
import com.desafio.desafiospring.entities.user.User;

import java.util.*;

import com.desafio.desafiospring.repositories.Repo;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo implements Repo {

    private static List<User> FILE = new ArrayList<>();

    @Autowired
    private ObjectMapper mapper;

    private List<User> loadData(){


        return FILE;

    }


    @Override
    public List<User> findAll() {

        List<User> u = loadData();
        return u;
    }

    @Override
    public User findById(long id) {

        try{

            Optional<User> oUser = loadData().stream().filter(x-> x.getUserId() == id).findFirst();

            return oUser.isPresent() ? oUser.get(): null;

        }catch (NoSuchElementException e){
            throw new RuntimeException("Elemento nao encontrado");
        }

    }

    @Override
    public User save(Object obj) {

        User user = new User((UserDto) obj);

        List<User> users = loadData();

        if(users.isEmpty()){
            user.setUserId(0L);
            users.add(user);
        }else{
            // faço uma função max pelo hash map para encontrar o maior id cadastrado e acrescento 1, desta forma nunca repito o id mesmo removendo um elemento
            long id = users.stream().max(Comparator.comparingLong(User::getUserId)).get().getUserId()+1;

            user.setUserId(id);
            users.add(user);

        }

        return user;

    }

    @Override
    public void delete(long id) {

        List<User> users = loadData();

        users.removeIf(x->x.getUserId() == id);

    }

    public String follow(long idUserFollowing, long idUserToFollow){

        User userToFollow = findById(idUserToFollow);
        User follower = findById(idUserFollowing);

        userToFollow.getFollowers().add(follower);
        follower.getFollowed().add(userToFollow);

        return "Seguidor vinculado";

    }

}
