package com.example.demo.student.service.interface;

import com.example.demo.student.dto.StudentDTO;
import java.util.List;
import java.util.UUID;

public interface StudentServiceInterface {
    List<StudentDTO> getStudents();
    void addNewStudent(StudentDTO studentDTO);
    void deleteStudent(UUID studentId);
    void updateStudent(UUID studentId, StudentDTO studentDTO);
}
