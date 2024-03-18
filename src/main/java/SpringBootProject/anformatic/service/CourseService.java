package SpringBootProject.anformatic.service;

import SpringBootProject.anformatic.AnformaticApplication;
import SpringBootProject.anformatic.repository.StudentRepository;
import SpringBootProject.anformatic.model.Master;
import SpringBootProject.anformatic.repository.MasterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import SpringBootProject.anformatic.model.Course;
import SpringBootProject.anformatic.repository.CourseRepository;

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
    MasterRepository  masterRepository;
    @Autowired
    MasterService  masterService;
    @Autowired
    CourseService  courseService;

    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository, MasterRepository masterRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.masterRepository = masterRepository;
    }

    public CourseService(MasterService masterService, CourseService courseService) {
        this.masterService = masterService;
        this.courseService = courseService;

    }

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public Course createCourse(String name,Long courseId,Long masterId){
        Master master=new Master();
        Course course=new Course();
        if(master!=null){
            course.setTitle(name);
            course.setId(courseId);
            master.setId(masterId);
            course.setMaster(master);
            return courseRepository.save(course) ;
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

//
//    @Transactional
//    public Course save(Course course) {
//        return courseRepository.save(course);
//    }
}
