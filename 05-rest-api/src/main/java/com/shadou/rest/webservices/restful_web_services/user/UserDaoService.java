package com.shadou.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static int usersCount = 0;
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Tom", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Sarah", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        Predicate<User> userPredicate = user -> user.getId().equals(id);
        return users
                .stream()
                .filter(userPredicate).
                findFirst()
                .orElse(null);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<User> userPredicate = user -> user.getId().equals(id);
        users.removeIf(userPredicate);
    }

}
