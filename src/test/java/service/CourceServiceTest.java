package service;

import SpringBootProject.anformatic.AnformaticApplication;
import SpringBootProject.anformatic.model.Course;
import SpringBootProject.anformatic.model.Master;
import SpringBootProject.anformatic.repository.CourseRepository;
import SpringBootProject.anformatic.repository.MasterRepository;
import SpringBootProject.anformatic.service.CourseService;
import SpringBootProject.anformatic.service.MasterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

public class CourceServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
    @Mock
    CourseRepository courseRepository;
    @Mock
    MasterRepository masterRepository;
    @InjectMocks
    CourseService courseService;
    @InjectMocks
    MasterService masterService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCourseById() {
        Long courseId = 1L;
        String title = "mathematics";
        Course course = new Course();
        course.setId(courseId);
        course.setTitle(title);
        Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
        Course retrieveCourse = courseService.getCourseById(courseId);
        Assertions.assertEquals(courseId, retrieveCourse.getId());
        Assertions.assertEquals(title, retrieveCourse.getTitle());
        logger.info("TestGetCourseById passed.");
    }

    @Test
    public void testCreateCourse() {
        String title = "physics";
        Long masterId = 10L;
        Long courseId = 10L;
        Course course = new Course();
        course.setTitle(title);
        course.setId(courseId);
        Master master = new Master();
        master.setId(masterId);
        master.setName(title);
//        Mockito.when(masterRepository.findById(masterId)).thenReturn(Optional.of(master));
        Mockito.when(masterRepository.save(any())).thenReturn(master);
        Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
        Mockito.when(courseRepository.save(any())).thenReturn(course);
        Master master1 = masterService.createMaster(master.getName());
        Course createCourse = courseService.createCourse(course.getTitle(), course.getId(), master.getId());
        Assertions.assertEquals(title, createCourse.getTitle());
        Assertions.assertEquals(masterId, master1.getId());
        logger.info("TestCreateCourse passed.");
    }
}
