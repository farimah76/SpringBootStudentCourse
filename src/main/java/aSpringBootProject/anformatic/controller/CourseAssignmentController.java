package aSpringBootProject.anformatic.controller;

import aSpringBootProject.anformatic.AnformaticApplication;
import aSpringBootProject.anformatic.service.CourseAssignmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courseAssignment")
public class CourseAssignmentController {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
    @Autowired
    private CourseAssignmentService courseAssignmentService;
    @PostMapping("/assign")
    public void courseAssignment(@RequestParam Long studentId,@RequestParam Long courseId){
        logger.info("courseAssignment studentId :"+studentId + "courseId :"+ courseId);
        courseAssignmentService.assignmentCourseTo(studentId,courseId);
    }
}
