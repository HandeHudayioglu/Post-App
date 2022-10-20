package com.handehdy.utility;

import com.handehdy.manager.IPostManager;
import com.handehdy.repository.entity.Post;
import com.handehdy.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Data {
    @Autowired
    private IPostManager postManager;
    @Autowired
    private PostService postService;

    @PostConstruct
    public void init(){
       // postService.save((Post) postManager.getAll().getBody());
        postManager.getAll().getBody().forEach(x -> {
            postService.save(Post.builder()
                            .postId(x.getPostId())
                            .title(x.getTitle())
                            .text(x.getText())
                            .createdDate(x.getCreatedDate())
                            .build());
        } );

    }
}
