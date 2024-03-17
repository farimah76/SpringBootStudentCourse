package service;

import aSpringBootProject.anformatic.model.Course;
import aSpringBootProject.anformatic.model.Master;
import aSpringBootProject.anformatic.model.Student;
import aSpringBootProject.anformatic.repository.CourseRepository;
import aSpringBootProject.anformatic.repository.StudentRepository;
import aSpringBootProject.anformatic.service.CourseService;
import aSpringBootProject.anformatic.service.StudentService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

public class CourceServiceTest {

    @Mock
    CourseRepository courseRepository;
    @InjectMocks
    CourseService courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private Course course=new Course();

    @Before()
    public void init() {

        course = new Course(20L,(short)2,"fizik");
    }
    @Test
    public void testCreateCourse(){
        Long masterId=10L;
        Master master=new Master();
       master.setId(masterId);
        Course course1=new Course();
        String title="kak";
        Long id=10L;
        course1.setTitle(title);
        course1.setMaster(master);
//        course1.setId(id);
//        course1.getMaster().setId(10L);
        Mockito.when(courseRepository.save(any())).thenReturn(course1);

        Course createCourse=courseService.createCourse(title,masterId);
       Assertions.assertNotNull(createCourse);
//        Long createMsterId= 30L;
//        createCourse.getMaster().setId(createMsterId);
//        Assertions.assertEquals(title,createCourse.getTitle());
//        Assertions.assertEquals(masterId,createMsterId);
        Mockito.verify(courseRepository, Mockito.times(1)).save(Mockito.any());
        Mockito.verifyNoMoreInteractions(courseRepository);
    }
}
