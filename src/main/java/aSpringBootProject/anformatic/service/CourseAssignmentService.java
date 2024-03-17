package aSpringBootProject.anformatic.service;

import aSpringBootProject.anformatic.model.Course;
import aSpringBootProject.anformatic.model.Student;
import aSpringBootProject.anformatic.repository.StudentRepository;
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
        Student student=studentService.getStudentById(studentId);
        Course course=courseService.getCourseById(courseId);
        if (student!=null && course!=null){
            student.getCourses().add(course);
            studentRepository.save(student);
        }
    }
}
