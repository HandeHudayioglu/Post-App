package com.handehdy.controller;

import com.handehdy.dto.PostCreateRequest;
import com.handehdy.dto.PostUpdateRequest;
import com.handehdy.exception.ErrorType;
import com.handehdy.exception.PostManagerException;
import com.handehdy.repository.entity.Post;
import com.handehdy.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.handehdy.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + POST)
@RequiredArgsConstructor
public class PostController {

   private final PostService postService;



    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createOnePost(@RequestBody PostCreateRequest newPostRequest){
        try {
            postService.createOnePost(newPostRequest);
            return ResponseEntity.ok(true);
        } catch (Exception e){
            throw new PostManagerException(ErrorType.POST_DONT_CREATE);
        }

    }

    @GetMapping(GET_ALL_BY_ID)
    public Optional<Post> getById(Long postId){
        return (Optional<Post>) postService.getById(postId);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Post>> getAll(){
        return ResponseEntity.ok(postService.getAllPost());
    }


    @PostMapping(UPDATE)
    public Post updateOnePost(@PathVariable  Long postId, @RequestBody PostUpdateRequest updatePostRequest){
        return postService.updateOnePost(String.valueOf(postId),updatePostRequest);
    }

    @DeleteMapping(DELETE)
    public void deleteOnePost(@PathVariable Long postId){
        postService.deleteOnePostById(postId);
    }


    @GetMapping("/getallpost")
    public List<Post> getAllPost(){
         return postService.getAllCache();
    }


}


