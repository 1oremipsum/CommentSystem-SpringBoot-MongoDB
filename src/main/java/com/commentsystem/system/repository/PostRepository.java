package com.commentsystem.system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.commentsystem.system.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
   
}
