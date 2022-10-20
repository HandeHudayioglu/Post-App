package com.handehdy.controller;

import com.handehdy.repository.entity.Post;
import com.handehdy.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.handehdy.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + POST)
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    @PostMapping(SAVE)
    public ResponseEntity<Boolean> createOnePost(@RequestBody Post post){
          postService.save(post);
          return ResponseEntity.ok(true);
    }

    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> updateOnePost(@RequestBody Post post){
        postService.updateOnePost(post);
        return ResponseEntity.ok(true);
    }

    @PostMapping(DELETE)
    public ResponseEntity<Boolean> delete(@RequestBody Long postId){
        postService.deleteOnePostById(postId);
        return ResponseEntity.ok(true);
    }
    @GetMapping(GET_ALL)
    public ResponseEntity<Iterable<Post>> getAll(){
        return ResponseEntity.ok(postService.getAll());
    }
}
