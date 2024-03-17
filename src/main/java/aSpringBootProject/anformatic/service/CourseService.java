package aSpringBootProject.anformatic.service;

import aSpringBootProject.anformatic.AnformaticApplication;
import aSpringBootProject.anformatic.model.Master;
import aSpringBootProject.anformatic.repository.MasterRepository;
import aSpringBootProject.anformatic.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import aSpringBootProject.anformatic.model.Course;
import aSpringBootProject.anformatic.model.Student;
import aSpringBootProject.anformatic.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    MasterService masterService;
    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public Course createCourse(String name,Long masterId){
        Master master=masterService.getMasterById(masterId);
        if(master!=null){
            Course course=new Course();
            course.setTitle(name);
            course.setMaster(master);
            return courseRepository.save(course);
        }
        return null;
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElse(null);
    }






    public List<Course> getAllCourse() {

        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courseNew -> courses.add(courseNew));
        return courses;
    }

////    public Course findById(Long id) {
////        return courseRepository.findById(id).get();
////    }
//
//    @Transactional
//    public Course save(Course course) {
//        return courseRepository.save(course);
//    }
//
//    public List<Course> findCourseByStudentId() {
//
//        try {
//            Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//            Student student=studentRepository.findByUsernameQuery(authentication.getName());
//            return courseRepository.findCourseByStudentId(student);
//
//        } catch (Exception e) {
//            logger.error("CourseService -findCourseByStudentId has a error : " + e.getMessage());
//            return null;
//        }
//
//    }
}
