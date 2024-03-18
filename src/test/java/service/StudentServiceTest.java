package service;

//import org.junit.Before;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import SpringBootProject.anformatic.AnformaticApplication;
import SpringBootProject.anformatic.model.Student;
import SpringBootProject.anformatic.repository.StudentRepository;
import SpringBootProject.anformatic.service.StudentService;

        import java.util.Optional;

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
        logger.info("TestCreateStudent passed.");
    }
    @Test
    public void testGetCourseById(){
        Long studentId=1L;
        String name="reza rezaee";
        Student student=new Student();
        student.setId(studentId);
        student.setName(name);
        Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        Student retrieveStudent =studentService.getStudentById(studentId);
        Assertions.assertEquals(studentId, retrieveStudent.getId());
        Assertions.assertEquals(name, retrieveStudent.getName());
        logger.info("TestGetCourseById passed.");
    }
}
