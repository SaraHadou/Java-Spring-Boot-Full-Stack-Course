package com.shadou.springboot.learnjpaandhibernate.course;

import com.shadou.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.shadou.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.shadou.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    // Modified this part of code to match data jpa repository.
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS JPA!", "Udemy"));
        repository.save(new Course(2, "Learn Azure JPA!", "Udemy"));
        repository.save(new Course(3, "Learn Spring Boot JPA!", "Udemy"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByName("Learn Azure JPA!"));
        System.out.println(repository.findByAuthor("Udemy"));
    }

}
