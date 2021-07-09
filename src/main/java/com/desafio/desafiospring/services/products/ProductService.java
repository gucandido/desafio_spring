package com.desafio.desafiospring.services.products;

import com.desafio.desafiospring.dto.products.PostInputDto;
import com.desafio.desafiospring.dto.products.FollowedPostsOutputDto;
import com.desafio.desafiospring.dto.products.PostOutPutDto;
import com.desafio.desafiospring.dto.users.FollowedDto;
import com.desafio.desafiospring.dto.users.UserOutputDto;
import com.desafio.desafiospring.entities.products.Detail;
import com.desafio.desafiospring.entities.products.Post;
import com.desafio.desafiospring.entities.user.User;
import com.desafio.desafiospring.repositories.products.DetailRepo;
import com.desafio.desafiospring.repositories.products.PostRepo;
import com.desafio.desafiospring.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private PostRepo postRepository;
    private DetailRepo detailRepository;
    private UserService userService;

    public ProductService() {
    }

    @Autowired
    public ProductService(PostRepo postRepo, DetailRepo detailRepo, UserService userServ) {
        this.postRepository = postRepo;
        this.detailRepository = detailRepo;
        this.userService = userServ;
    }

    public PostInputDto create(PostInputDto postDto) {

        User seller = userService.findById(postDto.getUserId());

        Detail detail = detailRepository.save(postDto.getDetail());

        Post post = new Post(seller,postDto.getDate(), detail,postDto.getCategory(),postDto.getPrice());

        postRepository.save(post);

        return postDto;

    }

    public List<FollowedPostsOutputDto> listFollowedPosts(long userIdToGetFollowed, Optional<String> order) {

        FollowedDto followeds = userService.getFollowedList(userIdToGetFollowed, Optional.empty());
        List<FollowedPostsOutputDto> followedPosts = new ArrayList<>();

        for (UserOutputDto user: followeds.getFollowed()) {

            List<PostOutPutDto> posts = new ArrayList<>();
            postRepository.findByUser(user.getUserId()).forEach(x->posts.add(PostOutPutDto.classToDto(x)));
            List<PostOutPutDto> twoWeeksPosts = getLastTwoWeeks(posts);
            orderListBy(twoWeeksPosts, order);
            followedPosts.add(new FollowedPostsOutputDto(user.getUserId(), twoWeeksPosts));

        }

        return followedPosts;

    }

    private void orderListBy(List<PostOutPutDto> list, Optional<String> order){

        if(order.isPresent()){
            switch (order.get()){
                case "date_asc":
                    list.sort(Comparator.comparing(PostOutPutDto::getDate));
                    break;
                case "date_desc":
                    list.sort(Comparator.comparing(PostOutPutDto::getDate));
                    Collections.reverse(list);
                    break;
                default:
                    Collections.sort(list);

            }
        } else {
            Collections.sort(list);
        }

    }

    public List<PostOutPutDto> getLastTwoWeeks(List<PostOutPutDto> posts){

        return posts.stream().filter(x->x.getDate().isAfter(LocalDate.now().minusWeeks(2))).collect(Collectors.toList());
    }



}
