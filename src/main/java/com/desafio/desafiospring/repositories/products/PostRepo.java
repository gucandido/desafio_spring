package com.desafio.desafiospring.repositories.products;

import com.desafio.desafiospring.entities.products.Post;
import com.desafio.desafiospring.exceptions.products.PostNotFound;
import com.desafio.desafiospring.repositories.Repo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostRepo implements Repo {

    private static List<Post> FILE = new ArrayList<>();

    private List<Post> loadData(){
        return FILE;
    }

    @Override
    public List<Post> findAll() {
        return loadData();
    }

    @Override
    public Post findById(long id) {
        Optional<Post> oPost = loadData().stream().filter(x-> x.getIdPost() == id).findFirst();

        if(oPost.isPresent())
            return oPost.get();
        else
            throw new PostNotFound("Post não cadastrado");
    }

    public List<Post> findByUser(long userId){

        List<Post> posts = findAll().stream().filter(x->x.getUser().getUserId() == userId).collect(Collectors.toList());

        return posts;

    }

    @Override
    public Post save(Object obj) {

        Post post = (Post) obj;

        List<Post> posts = loadData();

        if(posts.isEmpty()){
            post.setIdPost(0L);
            posts.add(post);
        }else{
            // faço uma função max pelo arraylist para encontrar o maior id cadastrado e acrescento 1, desta forma nunca repito o id mesmo removendo um elemento
            long id = posts.stream().max(Comparator.comparingLong(Post::getIdPost)).get().getIdPost()+1;

            post.setIdPost(id);
            posts.add(post);

        }

        return post;

    }

    @Override
    public void delete(long id) {
        List<Post> posts = loadData();

        posts.removeIf(x->x.getIdPost() == id);
    }

}
