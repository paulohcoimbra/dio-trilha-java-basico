package com.home.course.dio_design_patterns.service.impl;

import com.home.course.dio_design_patterns.model.Joke;
import com.home.course.dio_design_patterns.model.User;
import com.home.course.dio_design_patterns.model.UserRepository;
import com.home.course.dio_design_patterns.service.JokeService;
import com.home.course.dio_design_patterns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @Autowired
    JokeService jokeService;

    @Override
    public void create(User user) {
        repo.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return repo.findAll();
    }

    @Override
    public void update(User user) {
        Optional<User> opt = findById(user.getId());

        if(opt.isEmpty())
            return;

        User userFromRepo = opt.get();
        userFromRepo.setName(user.getName());
        userFromRepo.setJokes(user.getJokes());

        repo.save(userFromRepo);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Joke addRandomJoke(User user) {
        Joke joke = jokeService.getJoke();
        user.addJoke(joke);

        repo.save(user);
        return joke;
    }
}
