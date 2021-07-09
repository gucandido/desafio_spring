package com.desafio.desafiospring.controllers;

import com.desafio.desafiospring.dto.products.PostInputDto;
import com.desafio.desafiospring.services.products.ProductService;
import com.desafio.desafiospring.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //US 0005
    @PostMapping("/newpost")
    public ResponseEntity<?> newProductPost(@RequestBody @Valid PostInputDto payload){
        return new ResponseEntity<>(productService.create(payload), HttpStatus.CREATED);
    }

    //US 0006 e US 0009
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedPosts(@PathVariable long userId, @PathParam("order") Optional<String> order){
        return new ResponseEntity<>(productService.listFollowedPosts(userId, order), HttpStatus.ACCEPTED);
    }

/*
    //US 0010
    @PostMapping("/newpromopost")
    public ResponseEntity<?> newProductPromoPost(@RequestBody @Valid PostInputDto payload){
        return null;
    }

    //US 0011
    @PostMapping("/{userId}/countPromo/")
    public ResponseEntity<?> countPromoPost(Integer userId){
        return null;
    }

    //US 0012
    @PostMapping("/{userId}/list/")
    public ResponseEntity<?> PromoPostList(Integer userId){
        return null;
    }*/

}
