package com.commentsystem.system.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.commentsystem.system.domain.Post;
import com.commentsystem.system.resource.util.URL;
import com.commentsystem.system.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired(required = true)
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/searchfor")
    public ResponseEntity<List<Post>> searchFor(
        @RequestParam(value = "text", defaultValue = "") String text,
        @RequestParam(value = "minDate", defaultValue = "") String minDate,
        @RequestParam(value = "maxDate", defaultValue = "") String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.searchFor(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}
