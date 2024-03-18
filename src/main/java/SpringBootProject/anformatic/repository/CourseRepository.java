package SpringBootProject.anformatic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import SpringBootProject.anformatic.model.Course;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

   Optional<Course> getCourseById(Long id);
//
//    List<Course> findCourseByStudentId(Student studentId);
//
//
//   Course findCourseByTitle(String title);

}
