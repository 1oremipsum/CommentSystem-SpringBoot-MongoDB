package com.commentsystem.system.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.commentsystem.system.domain.Post;
import com.commentsystem.system.domain.User;
import com.commentsystem.system.repository.PostRepository;
import com.commentsystem.system.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Alex Green", "alex@gmail.com");
        User u2 = new User(null, "Allan Sanches", "allan@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");
        User u4 = new User(null, "Maria Brown", "maria@gmail.com");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Post post1 = new Post(null, sdf.parse("10/11/2024"), "Partiu férias!", "Vou viajar para o Rio de Janeiro. Abraços!", u4);
        Post post2 = new Post(null, sdf.parse("11/11/2024"), "Bom dia", "Acordei feliz hoje!", u4);

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
