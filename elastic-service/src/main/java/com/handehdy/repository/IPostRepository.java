package com.handehdy.repository;

import com.handehdy.repository.entity.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends ElasticsearchRepository<Post,Long> {
    Post getReferenceById(Long postId);
}
