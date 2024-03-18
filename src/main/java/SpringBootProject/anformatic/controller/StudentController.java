package SpringBootProject.anformatic.controller;

import SpringBootProject.anformatic.AnformaticApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import SpringBootProject.anformatic.model.Student;
import SpringBootProject.anformatic.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
    @Autowired
    StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/welcome")
    public String index() {
        return "welcome to my pages";
    }

    @GetMapping("/students")
    private List<Student> getAllStudent() {
        logger.info("getAllStudent");
        return studentService.getAllStudent();
    }
    @PostMapping("/create")
    public Student createStudent(@RequestParam String name,@RequestParam String userName) throws Exception {
        return studentService.createStudent(name,userName);
    }

    @GetMapping("/email")
    public Student findStudentByEmail(@PathVariable String email) throws Exception {
        return studentService.findByEmail(email);
    }

    @GetMapping("{studentid}")
    private Student getStudentById(@PathVariable("studentid") Long studentId) {

        logger.info("getting studentId");
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/saveStudent")
    private Long saveStudent(@RequestBody Student student) throws Exception {
        logger.info("save students");
        studentService.saveStudent(student);
        return student.getId();
    }
}
