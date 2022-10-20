package com.handehdy.manager;

import com.handehdy.dto.response.PostResponseDto;
import com.handehdy.repository.entity.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.handehdy.constants.ApiUrls.GET_ALL;

@FeignClient(value = "${postapplication.url.post}v1/api/post", name = "postmanagement-service-post", decode404 = true)
public interface IPostManager {

    @GetMapping(GET_ALL)
    public ResponseEntity<List<PostResponseDto>> getAll();
}
