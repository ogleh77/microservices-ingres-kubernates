package org.ogleh.students;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentCourse {
    private int studentID;
    private int courseID;
    private String studentName;
    private String courseName;
}
