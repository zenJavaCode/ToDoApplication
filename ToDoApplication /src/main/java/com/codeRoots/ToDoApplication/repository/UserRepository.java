package com.codeRoots.ToDoApplication.repository;

import com.codeRoots.ToDoApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods here if needed
    Optional<User> findByEmail(String email);

//    Optional<User> findByUsername(String username);
}
