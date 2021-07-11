package com.desafio.desafiospring.controllers;

import com.desafio.desafiospring.dto.generics.ResponseDto;
import com.desafio.desafiospring.dto.users.UserInputDto;
import com.desafio.desafiospring.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // cadastrar usuario
    @PostMapping("")
    public ResponseEntity<?> postUser(@RequestBody @Valid UserInputDto user){

        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);

    }

    // get all users test
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.listAll(), HttpStatus.ACCEPTED);
    }

    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        return new ResponseEntity<>(userService.findByIdOutput(id), HttpStatus.ACCEPTED);
    }

    //US 0001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable long userId,@PathVariable long userIdToFollow){
        return new ResponseEntity<>(new ResponseDto(userService.follow(userId,userIdToFollow)), HttpStatus.CREATED);
    }

    //US 0002
    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<?> followerCount(@PathVariable long userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.ACCEPTED);
    }

     //US 0003 e US0008
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followerList(@PathVariable long userId, @PathParam("order") Optional<String> order){
        return new ResponseEntity<>(userService.getFollowersList(userId, order), HttpStatus.ACCEPTED);
    }

    //US 0004 e US0008
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> followedList(@PathVariable long userId, @PathParam("order") Optional<String> order){
        return new ResponseEntity<>(userService.getFollowedList(userId, order), HttpStatus.ACCEPTED);
    }

    //US 0007
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable long userId, @PathVariable long userIdToUnfollow){
        return new ResponseEntity<>(new ResponseDto(userService.unfollow(userId, userIdToUnfollow)), HttpStatus.ACCEPTED);
    }

}
