package com.handehdy.service;

import com.handehdy.dto.PostCreateRequest;
import com.handehdy.dto.PostUpdateRequest;
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

    public Post createOnePost(PostCreateRequest newPostRequest) {
        Post toSave = new Post();
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setCreatedDate(new Date());
        return postRepository.save(toSave);

    }

    public Post updateOnePost(String postId, PostUpdateRequest updatePostRequest) {
        Optional<Post> post = postRepository.findById(Long.valueOf(postId));
        if (post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(updatePostRequest.getText());
            toUpdate.setTitle(updatePostRequest.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }
    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }


    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Optional<Post> getById(Long postId){
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            return postRepository.findById(postId);
        }
        return null;
    }

    @Cacheable(value = "post_getall")
    public List<Post> getAllCache() {
        return postRepository.findAll();
    }


}
