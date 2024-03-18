package SpringBootProject.anformatic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import SpringBootProject.anformatic.model.Student;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

   Optional<Student> findById(Long id);
//
//    @Modifying
//    @Transactional
//    @Query(value = "insert into units (Student_id, Course_id) VALUES (?, ?)", nativeQuery = true)
//    void getStudentCourses(Student student_id, Course course_id);
//
//    @Query(value = "select u from Student u where u.userName=:userName")
//    Student findByUsernameQuery(String userName);
//
//    Student findByFirstName(String firstName);
//
   Student findByEmail(String s);




}
