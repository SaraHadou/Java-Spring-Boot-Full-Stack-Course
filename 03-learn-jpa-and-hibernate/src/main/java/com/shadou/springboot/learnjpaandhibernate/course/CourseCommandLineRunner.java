package com.shadou.springboot.learnjpaandhibernate.course;

import com.shadou.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.shadou.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    public CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS JPA!", "Udemy"));
        repository.insert(new Course(2, "Learn Azure JPA!", "Udemy"));
        repository.insert(new Course(3, "Learn Spring Boot JPA!", "Udemy"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }

}
