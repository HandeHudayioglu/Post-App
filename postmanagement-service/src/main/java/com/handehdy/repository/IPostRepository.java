package com.handehdy.repository;

import com.handehdy.repository.entity.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends MongoRepository<Post,Long> {
}
