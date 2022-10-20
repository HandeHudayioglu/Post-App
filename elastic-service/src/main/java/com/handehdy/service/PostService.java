package com.handehdy.service;

import com.handehdy.repository.IPostRepository;
import com.handehdy.repository.entity.Post;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {
        super();
        this.postRepository = postRepository;
    }

    public Post updateOnePost(Post updatePost) {
       return postRepository.save(updatePost);
    }
    public void deleteOnePostById(Long postId) {

        postRepository.deleteById(postId);
    }
    public void save(Post post) {
        postRepository.save(post);
    }

    public Iterable<Post> getAll(){
        return postRepository.findAll();
    }

}


