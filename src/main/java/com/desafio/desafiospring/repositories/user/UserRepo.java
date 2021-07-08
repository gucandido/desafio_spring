package com.desafio.desafiospring.repositories.user;

import com.desafio.desafiospring.dto.users.UserDto;
import com.desafio.desafiospring.entities.user.User;

import java.util.*;

import com.desafio.desafiospring.enums.UserType;
import com.desafio.desafiospring.exceptions.FollowNotAllowed;
import com.desafio.desafiospring.exceptions.UserNotFound;
import com.desafio.desafiospring.repositories.Repo;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo implements Repo {

    private static List<User> FILE = new ArrayList<>();

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

            Optional<User> oUser = loadData().stream().filter(x-> x.getUserId() == id).findFirst();

            if(oUser.isPresent())
                return oUser.get();
            else
                throw new UserNotFound("Usuário não cadastrado");

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

        if(userToFollow.getType() != UserType.SELLER) {
            throw new FollowNotAllowed("O usuário a ser seguido deve ser um vendedor (seller)");
        }else if(follower.getType() != UserType.BUYER) {
            throw new FollowNotAllowed("O usuário que segue deve ser um comprador (buyer)");
        }else {

            userToFollow.getFollowers().add(follower);
            follower.getFollowed().add(userToFollow);

            return "Seguidor vinculado";
        }

    }

    public String unfollow(long idUserFollowing, long idUserToFollow){

        User userToFollow = findById(idUserToFollow);
        User follower = findById(idUserFollowing);

        userToFollow.getFollowers().removeIf(x->x.getUserId() == idUserFollowing);
        follower.getFollowed().removeIf(x->x.getUserId() == idUserToFollow);

            return "Seguidor desvinculado";

    }

    public boolean isFollower(long idUserFollowing, long idUserFollowed){

        User userFollowed = findById(idUserFollowed);

        return userFollowed.getFollowers().stream().anyMatch(user -> user.getUserId() == idUserFollowing);

    }

}
