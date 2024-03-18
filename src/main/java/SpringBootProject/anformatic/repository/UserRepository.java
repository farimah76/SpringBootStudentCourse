package SpringBootProject.anformatic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import SpringBootProject.anformatic.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findById(int id);
//
//    Optional<User> findByUserName(String userName);
//
//    @Query(value = "select u from User u where u.userName=:userName")
//    User findByUserNameQuery(String userName);
}
