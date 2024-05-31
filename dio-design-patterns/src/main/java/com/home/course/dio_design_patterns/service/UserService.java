package com.home.course.dio_design_patterns.service;

import com.home.course.dio_design_patterns.model.Joke;
import com.home.course.dio_design_patterns.model.User;

import java.util.Optional;

public interface UserService {
    void create(User user);
    Optional<User> findById(Long id);
    Iterable<User> findAll();
    void update(User user);
    void delete(Long id);
    Joke addRandomJoke(User user);
}
