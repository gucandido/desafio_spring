package com.desafio.desafiospring.controllers;

import com.desafio.desafiospring.dto.products.PostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    //US 0005
    @PostMapping("/newpost")
    public ResponseEntity<?> newProductPost(@RequestBody @Valid PostDto payload){
        return null;
    }

    //US 0006
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedPosts(@PathVariable Integer userId){
        return null;
    }

    //US 0009
    /*@GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedPostsOrderedAsc(@PathVariable Integer userId, @PathParam("asc") String order){
        return null;
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedPostsOrderedDesc(@PathVariable Integer userId){
        return null;
    }


    //US 0010
    @PostMapping("/newpromopost")
    public ResponseEntity<?> newProductPromoPost(@RequestBody @Valid PostDto payload){
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
