package com.home.course.dio_design_patterns.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.home.course.dio_design_patterns.model.Joke;

@FeignClient(name = "joke", url = "https://geek-jokes.sameerkumar.website/api?format=json")
public interface JokeService {
    @RequestMapping()
    Joke getJoke();
}
