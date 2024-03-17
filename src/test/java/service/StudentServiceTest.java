package service;

import aSpringBootProject.anformatic.repository.CourseRepository;
//import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import aSpringBootProject.anformatic.AnformaticApplication;
import aSpringBootProject.anformatic.model.Student;
import aSpringBootProject.anformatic.repository.StudentRepository;
import aSpringBootProject.anformatic.service.StudentService;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;

public class StudentServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);

    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private Student student;

    @Test
    public void testCreateStudent() throws Exception {
        String studentName = "farimah";
        String studentUserName = "farimah76";
        Student student = new Student();
        student.setName(studentName);
        student.setUserName(studentUserName);
        Mockito.when(studentRepository.save(any())).thenReturn(student);

        Student createStudent = studentService.createStudent(studentName, studentUserName);
        Assertions.assertNotNull(createStudent);
        Assertions.assertEquals(studentName, createStudent.getName());
        Assertions.assertEquals(studentUserName, createStudent.getUserName());
        Mockito.verify(studentRepository, Mockito.times(1)).save(Mockito.any());
        Mockito.verifyNoMoreInteractions(studentRepository);
    }

}
