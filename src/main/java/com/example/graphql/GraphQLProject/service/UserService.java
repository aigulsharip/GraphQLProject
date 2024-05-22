package com.example.graphql.GraphQLProject.service;

import com.example.graphql.GraphQLProject.model.User;
import com.example.graphql.GraphQLProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public boolean deleteUser(Long id) {
        User user = getUser(id);
        if (user != null) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
