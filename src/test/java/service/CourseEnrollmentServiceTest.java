package service;

import SpringBootProject.anformatic.AnformaticApplication;
import SpringBootProject.anformatic.model.Course;
import SpringBootProject.anformatic.model.Master;
import SpringBootProject.anformatic.model.Student;
import SpringBootProject.anformatic.repository.CourseRepository;
import SpringBootProject.anformatic.repository.MasterRepository;
import SpringBootProject.anformatic.repository.StudentRepository;
import SpringBootProject.anformatic.service.CourseService;
import SpringBootProject.anformatic.service.MasterService;
import SpringBootProject.anformatic.service.StudentService;
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

public class CourseEnrollmentServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
    @Mock
    CourseRepository courseRepository;
    @Mock
    StudentRepository studentRepository;
    @Mock
    MasterRepository masterRepository;
    @InjectMocks
    StudentService studentService;
    @InjectMocks
    CourseService courseService;
    @InjectMocks
    MasterService masterService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCourseEnrollmentServiceTest(){
        Long courseId=10L;
        Long studentId=1L;
        Long masterId=20L;
        Course course=new Course();
        Student student=new Student();
        Master master=new Master();
        course.setId(courseId);
        student.setId(studentId);
        master.setId(masterId);
        Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
        Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        Mockito.when(masterRepository.findById(masterId)).thenReturn(Optional.of(master));
        studentService.getStudentById(studentId);
        courseService.getCourseById(courseId);
        masterService.getMasterById(masterId);
        Assertions.assertNotNull(studentId);
        Assertions.assertNotNull(courseId);
        Assertions.assertNotNull(masterId);
        Mockito.verify(courseRepository, Mockito.times(1)).findById(courseId);
        Mockito.verify(studentRepository, Mockito.times(1)).findById(studentId);
        Mockito.verify(masterRepository, Mockito.times(1)).findById(masterId);
        Mockito.verifyNoMoreInteractions(courseRepository);
        Mockito.verifyNoMoreInteractions(studentRepository);
        Mockito.verifyNoMoreInteractions(masterRepository);
        logger.info("TestCourseEnrollmentServiceTest passed.");
    }
}
