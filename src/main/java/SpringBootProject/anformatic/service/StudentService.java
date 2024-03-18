package SpringBootProject.anformatic.service;

import SpringBootProject.anformatic.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import SpringBootProject.anformatic.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseService courseService;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }
    public List<Student> getAllStudent() {
        List<Student> students=new ArrayList<>();
        studentRepository.findAll().forEach(studentNew ->students.add(studentNew));
        return students;
    }

    public Student getStudentById(Long id) {

        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(String name,String userName) throws Exception {
      Student student=new Student();
      student.setName(name);
      student.setUserName(userName);
      return studentRepository.save(student);
    }
    public Student saveStudent(Student st){
        return studentRepository.save(st);
    }

    public Student findByEmail(String s) throws Exception {
        final Optional<Student> student=Optional.ofNullable(studentRepository.findByEmail(s));
        return student.orElseThrow(()->new Exception("Student not found"));
    }

}
