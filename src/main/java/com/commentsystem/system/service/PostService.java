package com.commentsystem.system.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commentsystem.system.domain.Post;
import com.commentsystem.system.repository.PostRepository;
import com.commentsystem.system.service.exception.ObjectNotFoundException;

@Service
public class PostService {
    
    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post not Found!"));
    }
}