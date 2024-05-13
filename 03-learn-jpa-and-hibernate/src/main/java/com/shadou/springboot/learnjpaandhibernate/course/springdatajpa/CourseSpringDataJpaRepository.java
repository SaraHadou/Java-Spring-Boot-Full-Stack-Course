package com.shadou.springboot.learnjpaandhibernate.course.springdatajpa;

import com.shadou.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
    List<Course> findByAuthor(String author);
}
