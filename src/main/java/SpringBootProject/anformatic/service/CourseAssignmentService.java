package SpringBootProject.anformatic.service;

import SpringBootProject.anformatic.model.Course;
import SpringBootProject.anformatic.repository.StudentRepository;
import SpringBootProject.anformatic.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseAssignmentService {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
     CourseService courseService;

    public void assignmentCourseTo(Long studentId,Long courseId){
        Student student=new Student();
        Course course=new Course();
        if (student!=null && course!=null){
            student.setId(studentId);
            course.setId(courseId);
            student.getCourses().add(course);
            studentRepository.save(student);
        }
    }
}
