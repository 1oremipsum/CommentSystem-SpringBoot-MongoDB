package com.commentsystem.system.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.commentsystem.system.domain.User;
import com.commentsystem.system.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        
        for (User u : instantiateUsers()) {
            userRepository.save(u);
        }
    }

    private List<User> instantiateUsers(){
        List<User> list = new ArrayList<>();
        list.add(new User(null, "Alex Green", "alex@gmail.com"));
        list.add(new User(null, "Allan Sanches", "allan@gmail.com"));
        list.add(new User(null, "Bob Grey", "bob@gmail.com"));
        list.add(new User(null, "Maria Brown", "maria@gmail.com"));
        return list;
    }
    
}
