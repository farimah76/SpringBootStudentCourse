package aSpringBootProject.anformatic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import aSpringBootProject.anformatic.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

//    Optional<User> findById(int id);
//
//    Optional<User> findByUserName(String userName);
//
//    @Query(value = "select u from User u where u.userName=:userName")
//    User findByUserNameQuery(String userName);
}
