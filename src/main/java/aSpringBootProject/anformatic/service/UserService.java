package aSpringBootProject.anformatic.service;

import aSpringBootProject.anformatic.model.User;
import aSpringBootProject.anformatic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findById(int id) {

        return userRepository.findById(id).get();
    }

    public void addUser(User user)
    {
        userRepository.save(user);
    }


}
