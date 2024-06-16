package com.shadou.learn_spring_security.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldResource {
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }
}

