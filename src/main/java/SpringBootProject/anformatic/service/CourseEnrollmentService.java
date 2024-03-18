package SpringBootProject.anformatic.service;

import SpringBootProject.anformatic.model.Course;
import SpringBootProject.anformatic.model.Master;
import SpringBootProject.anformatic.model.Student;
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
