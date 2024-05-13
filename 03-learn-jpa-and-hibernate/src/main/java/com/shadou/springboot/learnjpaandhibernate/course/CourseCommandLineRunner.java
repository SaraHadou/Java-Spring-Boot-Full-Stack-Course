package com.shadou.springboot.learnjpaandhibernate.course;

import com.shadou.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insertCourse(new Course(2, "Learn Azure", "Udemy"));
    }

}
