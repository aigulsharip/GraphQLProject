package com.example.graphql.GraphQLProject.repository;

import com.example.graphql.GraphQLProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
