package com.shadou.springboot.myWebApp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "Sarah", "Learn Full Stack Development",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "Sarah", "Learn AWS",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3, "Radwa", "Learn Devops",
                LocalDate.now().plusYears(3), false));

    }

    public List<Todo> findByUsername(String username) {
        return  todos.stream().filter(todo -> todo.getUsername()
                        .equalsIgnoreCase(username)).toList();
    }

}
