package com.example.graphql.GraphQLProject.controller;

import com.example.graphql.GraphQLProject.model.User;
import com.example.graphql.GraphQLProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserQueryResolver {

    private final UserService userService;



    @QueryMapping
    public List<User> findAllUsers() {
        return userService.getUsers();
    }

    @QueryMapping
    public User findUserById(@Argument Long id) {
        return userService.getUser(id);
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        return userService.addUser(user);
    }

    @MutationMapping
    public User updateUser(@Argument Long id, @Argument String name, @Argument String email) {
        User user = userService.getUser(id);
        if (user != null) {
            if (name != null) user.setName(name);
            if (email != null) user.setEmail(email);
            user = userService.updateUser(user);
            return user;
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Long id){
        return userService.deleteUser(id);
    }
}
