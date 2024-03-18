package SpringBootProject.anformatic.service;

import SpringBootProject.anformatic.model.User;
import SpringBootProject.anformatic.repository.UserRepository;
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
