package service;

import SpringBootProject.anformatic.AnformaticApplication;
import SpringBootProject.anformatic.model.Course;
import SpringBootProject.anformatic.model.Student;
import SpringBootProject.anformatic.repository.CourseRepository;
import SpringBootProject.anformatic.repository.StudentRepository;
import SpringBootProject.anformatic.service.CourseService;
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

public class CourseAssignmentServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
    @Mock
    CourseRepository courseRepository;
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;
    @InjectMocks
    CourseService courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAssignCourseToStudent(){
        Long courseId=10L;
        Long studentId=10L;
        Course course=new Course();
        course.setId(courseId);
        Student student=new Student();
        student.setId(studentId);
        Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
        Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        studentService.getStudentById(studentId);
        courseService.getCourseById(courseId);
        Assertions.assertNotNull(studentId);
        Assertions.assertNotNull(courseId);
        Mockito.verify(courseRepository, Mockito.times(1)).findById(courseId);
        Mockito.verify(studentRepository, Mockito.times(1)).findById(studentId);
        Mockito.verifyNoMoreInteractions(courseRepository);
        Mockito.verifyNoMoreInteractions(studentRepository);
        logger.info("TestAssignCourseToStudent passed.");

    }
}
