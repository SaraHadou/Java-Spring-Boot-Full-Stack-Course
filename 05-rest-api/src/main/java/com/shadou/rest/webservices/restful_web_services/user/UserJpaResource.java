package com.shadou.rest.webservices.restful_web_services.user;

import com.shadou.rest.webservices.restful_web_services.jpa.PostRepository;
import com.shadou.rest.webservices.restful_web_services.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class UserJpaResource {

    private UserRepository userRepository;

    private PostRepository postRepository;

    public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> retrieveUser(@PathVariable int id) {
        var user =  userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id: " + id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        var savedUser =  userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        var user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id: " + id);
        return user.get().getPosts();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<User> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        var user =  userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id: " + id);
        post.setUser(user.get());
        postRepository.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
