package aSpringBootProject.anformatic.controller;

import aSpringBootProject.anformatic.AnformaticApplication;
import aSpringBootProject.anformatic.model.Course;
import aSpringBootProject.anformatic.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    public Course createCourse(@RequestParam String name,@RequestParam Long masterId){
        logger.info("createCourse : name:" + name +"masterId :"+ masterId);
        return courseService.createCourse(name,masterId);
    }
    @GetMapping("{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

}
