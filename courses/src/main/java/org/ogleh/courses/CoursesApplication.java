package org.ogleh.courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class CoursesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursesApplication.class, args);
    }

    Map<Integer, String> courses = Map.of(1, "Somali", 2, "Arabic", 3, "English");


    @GetMapping("/{courseId}")
    public Course course(@PathVariable("courseId") int courseId) {
        if (!courses.containsKey(courseId)) {
            return null;
        }
        return Course.builder()
                .courseId(courseId)
                .courseName(courses.get(courseId)).build();
    }

    @GetMapping("")
    public Map<Integer, String> courses() {
        return courses;
    }
}
