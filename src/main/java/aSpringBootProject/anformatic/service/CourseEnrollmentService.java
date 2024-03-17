package aSpringBootProject.anformatic.service;

import aSpringBootProject.anformatic.model.Course;
import aSpringBootProject.anformatic.model.Master;
import aSpringBootProject.anformatic.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseEnrollmentService {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private MasterService masterService;

    public void enrollCourseWithMaster(Long studentId,Long courseId,Long masterId){
        Student student=studentService.getStudentById(studentId);
        Course course=courseService.getCourseById(courseId);
        Master master=masterService.getMasterById(masterId);
        if(student!=null && course!=null && master!=null){
            student.getCourses().add(course);
            studentService.saveStudent(student);
        }
        else
            throw new IllegalArgumentException("Invalid student,course,or master");
    }
}
