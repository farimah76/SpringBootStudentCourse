package service;

import aSpringBootProject.anformatic.model.Course;
import aSpringBootProject.anformatic.model.Student;
import aSpringBootProject.anformatic.repository.CourseRepository;
import aSpringBootProject.anformatic.repository.StudentRepository;
import aSpringBootProject.anformatic.service.CourseAssignmentService;
import aSpringBootProject.anformatic.service.CourseService;
import aSpringBootProject.anformatic.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class CourseAssignmentServiceTest {
    @Mock
    CourseRepository courseRepository;
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    CourseAssignmentService courseAssignmentService;
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
        courseAssignmentService.assignmentCourseTo(studentId,courseId);
        Assertions.assertTrue(student.getCourses().contains(course));
        Mockito.verify(courseRepository, Mockito.times(1)).findById(courseId);
        Mockito.verify(studentRepository, Mockito.times(1)).findById(studentId);
        Mockito.verifyNoMoreInteractions(courseRepository);
        Mockito.verifyNoMoreInteractions(studentRepository);

    }
}
