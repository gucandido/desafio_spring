package com.desafio.desafiospring.services.products;

import com.desafio.desafiospring.dto.products.*;
import com.desafio.desafiospring.dto.users.FollowedDto;
import com.desafio.desafiospring.dto.users.UserOutputDto;
import com.desafio.desafiospring.entities.products.Post;
import com.desafio.desafiospring.entities.user.User;
import com.desafio.desafiospring.enums.UserType;
import com.desafio.desafiospring.exceptions.products.InvalidPrice;
import com.desafio.desafiospring.exceptions.products.PostNotAllowed;
import com.desafio.desafiospring.exceptions.user.InvalidUserType;
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

        if(seller.getType() == UserType.SELLER){

            if(postDto.getPrice().doubleValue() > 0.0){

                Post post = postFactory(seller, postDto);

                post.setDetail(detailRepository.save(postDto.getDetail()));

                postRepository.save(post);

                return postDto;

            }else{
                throw new InvalidPrice("O preço do produto deve ser maior que 0");
            }

        }else{
            throw new PostNotAllowed("Para realizar um post o usuário precisa ser do tipo seller");
        }

    }

    public List<FollowedPostsOutputDto> listFollowedPosts(long userIdToGetFollowed, Optional<String> order) {

        FollowedDto followeds = userService.getFollowedList(userIdToGetFollowed, Optional.empty());
        List<FollowedPostsOutputDto> followedPosts = new ArrayList<>();

        for (UserOutputDto user: followeds.getFollowed()) {

            List<PostOutputDto> posts = new ArrayList<>();
            postRepository.findByUser(user.getUserId()).forEach(x->posts.add(PostOutputDto.classToDto(x)));
            List<PostOutputDto> twoWeeksPosts = getLastTwoWeeks(posts);
            orderListBy(twoWeeksPosts, order);
            followedPosts.add(new FollowedPostsOutputDto(user.getUserId(), twoWeeksPosts));

        }

        return followedPosts;

    }

    public CountPromoPostDto getPromoPostCount(long userId){

        User user = userService.findById(userId);
        if(user.getType() == UserType.SELLER) {
            long qtPromos = postRepository.findByUser(user.getUserId()).stream().filter(Post::isHasPromo).count();

            return new CountPromoPostDto(user.getUserId(), user.getUserName(), qtPromos);
        }else{
            throw new InvalidUserType("Apenas sellers possuem posts (O usuario passado é um buyer)");
        }

    }

    private void orderListBy(List<PostOutputDto> list, Optional<String> order){

        if(order.isPresent()){
            switch (order.get()){
                case "date_asc":
                    list.sort(Comparator.comparing(PostOutputDto::getDate));
                    break;
                case "date_desc":
                    list.sort(Comparator.comparing(PostOutputDto::getDate));
                    Collections.reverse(list);
                    break;
                default:
                    Collections.sort(list);

            }
        } else {
            Collections.sort(list);
        }

    }

    private List<PostOutputDto> getLastTwoWeeks(List<PostOutputDto> posts){
        return posts.stream().filter(x->x.getDate().isAfter(LocalDate.now().minusWeeks(2))).collect(Collectors.toList());
    }

    private Post postFactory(User seller, PostInputDto postDto){

        Post post;

        if(postDto.getClass().equals(PostInputDto.class)) {
            post = new Post(seller, postDto.getDate(), postDto.getCategory(), postDto.getPrice());
        }else if(postDto.getClass().equals(PromoPostInputDto.class)) {
            PromoPostInputDto promo = (PromoPostInputDto) postDto;
            post = new Post(seller, promo.getDate(), promo.getCategory(), promo.getPrice(), promo.isHasPromo(), promo.getDiscount());
        }else {
            throw new ClassCastException();
        }

        return post;
    }


}
