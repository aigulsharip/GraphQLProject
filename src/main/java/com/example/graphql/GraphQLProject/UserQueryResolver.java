package com.example.graphql.GraphQLProject;

import com.example.graphql.GraphQLProject.model.User;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller

public class UserQueryResolver {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1L, "john@doe.com", "John Doe"));
        users.add(new User(2L, "jane@doe.com", "Jane Doe"));
        users.add(new User(3L, "anna@doe.com", "Anna Doe"));
    }

    @QueryMapping
    public List<User> findAllUsers() {
        return users;
    }

    @QueryMapping
    public User findUserById(@Argument Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
}
