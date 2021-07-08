package com.desafio.desafiospring.controllers;

import com.desafio.desafiospring.dto.users.UserDto;
import com.desafio.desafiospring.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // cadastrar usuario
    @PostMapping("")
    public ResponseEntity<?> postUser(@RequestBody @Valid UserDto user){

        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);

    }

    // get all users test
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.listAll(), HttpStatus.ACCEPTED);
    }

    // get all users test
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.ACCEPTED);
    }

    //US 0001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable long userId,@PathVariable long userIdToFollow){
        return new ResponseEntity<>(userService.follow(userId,userIdToFollow), HttpStatus.CREATED);
    }

    //US 0002
    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<?> followerCount(@PathVariable long userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.ACCEPTED);
    }

    /* //US 0003
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followerList(Integer userId, Integer userIdToFollow){
        return null;
    }

    //US 0004
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> followedList(Integer userId, Integer userIdToFollow){
        return null;
    }

    //US 0007
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(Integer userId, Integer userIdToUnfollow){
        return null;
    }

    //US 0008
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followerListOrdered (Integer userId){
        return null;
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> followedListOrdered(Integer userId){
        return null;
    }*/


}
