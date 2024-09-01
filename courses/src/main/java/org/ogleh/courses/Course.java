package org.ogleh.courses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class Course {
    private int courseId;
    private String courseName;
}