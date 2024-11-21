package com.commentsystem.system.service;

import java.util.Date;
import java.util.List;
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

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }

    public List<Post> searchFor(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.searchFor(text, minDate, maxDate);
    }
}
