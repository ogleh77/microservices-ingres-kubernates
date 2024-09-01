package org.ogleh.students;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RestController
@RequiredArgsConstructor
public class StudentController {
    @Value("${course.url:localhost}")
    String url;
    private final RestTemplate restTemplate;
    Map<Integer, String> students = Map.of(1, "Mohamed", 2, "Saeed", 3, "Ogleh", 4, "Jamac");

    @GetMapping("/{studentId}")
    public ResponseEntity<?> students(@PathVariable("studentId") int studentId) {
        if (!students.containsKey(studentId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students not exist");
        }

        Course course = restTemplate.getForObject("http://" + url + ":8080/" + studentId, Course.class);

        if (course == null) {
            course = new Course(0, "no course exist");
        }

        StudentCourse studentCourse = StudentCourse.builder()
                .courseID(course.getCourseId())
                .courseName(course.getCourseName())
                .studentID(studentId)
                .studentName(students.get(studentId))
                .build();


        return ResponseEntity.status(HttpStatus.OK).body(studentCourse);
    }

    @GetMapping("")
    public Map<Integer, String> students() {
        return students;
    }
}
