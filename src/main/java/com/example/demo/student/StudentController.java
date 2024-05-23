package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/student")
public class StudentController {
    private final StudentService studentService;
@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping//for method to be served as restful endpoint
    public List<Student> getStudents(){
return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){ //we take request body and map it into student
    studentService.addNewStudent(student);
    }
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
    studentService.deleteStudent(studentId);
    }
    @PutMapping(path="{studentId}") //we use Put when we want to update sth
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
    studentService.updateStudent(studentId, name, email);
    }
}
