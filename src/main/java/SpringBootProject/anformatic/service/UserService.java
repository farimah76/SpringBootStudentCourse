package SpringBootProject.anformatic.service;

import SpringBootProject.anformatic.model.Student;
import SpringBootProject.anformatic.model.User;
import SpringBootProject.anformatic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(String userName,Long password) throws Exception {
        User user=new User();
        user.setUserName(userName);
        user.setPassword(password);
        return userRepository.save(user);
    }
    public User saveUsers(User user){
        return userRepository.save(user);
    }


    public User findUserById(Long id) {

        return userRepository.findById(id).orElse(null);
    }
    public List<User> getAllUser() {
        List<User> users=new ArrayList<>();
        userRepository.findAll().forEach(userNew ->users.add(userNew));
        return users;
    }

    public void addUser(User user)
    {
        userRepository.save(user);
    }


}
