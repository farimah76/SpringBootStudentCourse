package aSpringBootProject.anformatic.controller;

import aSpringBootProject.anformatic.AnformaticApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import aSpringBootProject.anformatic.model.Student;
import aSpringBootProject.anformatic.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);

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
    @GetMapping("{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("email")
    public Student findStudentByEmail(@PathVariable String email) throws Exception {
        return studentService.findByEmail(email);
    }
//
//    @GetMapping("/student/{studentid}")
//    private Student getStudentById(@PathVariable("studentid") Long studentId) {
//
//        logger.info("getting studentId");
//        return studentService.findById(studentId);
//    }
//
//    @PostMapping("/saveStudent")
//    private Long saveBook(@RequestBody Student student) throws Exception {
//        logger.info("Creating a student");
//        studentService.addStudent(student);
//        return student.getId();
//    }
//
//    @RequestMapping(value = "/courseAssignment", method = RequestMethod.GET)
//    public String addCourse(Model model) {
//        List<Course> courses = (List<Course>) courseRepository.findAll();
//        model.addAttribute("course", courses);
//        model.addAttribute("student", new Student());
//        model.addAttribute("studentCources", courseService.findCourseByStudentId());
//
//        return courses.toString();
//    }
}