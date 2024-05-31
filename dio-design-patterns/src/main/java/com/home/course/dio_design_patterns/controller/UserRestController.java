package com.home.course.dio_design_patterns.controller;

import com.home.course.dio_design_patterns.model.Joke;
import com.home.course.dio_design_patterns.model.User;
import com.home.course.dio_design_patterns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController()
@RequestMapping("users")
public class UserRestController {

    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<Iterable<User>> getAll() {
        Iterable<User> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getOne(@PathVariable Long id) {
        Optional<User> opt = service.findById(id);

        return opt.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody User user) {
        service.create(user);

        URI newResourceURI = ServletUriComponentsBuilder.fromCurrentRequest()
                                                        .path("/{id}")
                                                        .buildAndExpand(user.getId())
                                                        .toUri();

        return ResponseEntity.created(newResourceURI).build();
    }

    @PutMapping()
    public ResponseEntity<User> update(User user) {
        service.update(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/random")
    public ResponseEntity<Joke> addRandomJoke(@PathVariable Long id) {
        Optional<User> opt = service.findById(id);

        if(opt.isEmpty())
            return ResponseEntity.notFound().build();

        Joke joke = service.addRandomJoke(opt.get());

        return ResponseEntity.ok(joke);
    }
}
