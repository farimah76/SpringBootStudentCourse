package aSpringBootProject.anformatic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aSpringBootProject.anformatic.model.Course;
import aSpringBootProject.anformatic.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

   Optional<Course> findById(Long id);
//
//    List<Course> findCourseByStudentId(Student studentId);
//
//
//   Course findCourseByTitle(String title);

}
