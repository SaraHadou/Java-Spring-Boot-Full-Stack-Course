package com.shadou.springboot.learnjpaandhibernate.course.jdbc;

import com.shadou.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
           """ 
                INSERT INTO course (id, name, author) 
                VALUES (?, ?, ?);
           """;

    @Transactional
    public void insertCourse(Course course) {
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }


}
