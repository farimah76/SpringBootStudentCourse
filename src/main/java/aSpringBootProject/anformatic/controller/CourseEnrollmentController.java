package aSpringBootProject.anformatic.controller;

import aSpringBootProject.anformatic.AnformaticApplication;
import aSpringBootProject.anformatic.service.CourseEnrollmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courseEnrollment")
public class CourseEnrollmentController {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
    @Autowired
    private CourseEnrollmentService courseEnrollmentService;
    @PostMapping("/enroll")
    public void enrollCourseWithMaster(@RequestParam Long studentId,@RequestParam Long courseId,@RequestParam Long masterId){
        logger.info("enrollCourseWithMaster studentId :" +studentId +"courseId :"+courseId + "masterId :" +masterId);
        courseEnrollmentService.enrollCourseWithMaster(studentId,courseId,masterId);
    }
}
