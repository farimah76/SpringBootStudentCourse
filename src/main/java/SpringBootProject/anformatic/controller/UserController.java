package SpringBootProject.anformatic.controller;

import SpringBootProject.anformatic.AnformaticApplication;
import SpringBootProject.anformatic.model.Student;
import SpringBootProject.anformatic.model.User;
import SpringBootProject.anformatic.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    private List<User> getAllUsers() {
        logger.info("getAllUsers  Done.");
        return userService.getAllUser();
    }
    @PostMapping("/create")
    public User createUser(@RequestParam String userName,@RequestParam Long password) throws Exception {
        logger.info("createUser Done.");
        return userService.createUser(userName,password);
    }

    @GetMapping("{userid}")
    private User getUseridById(@PathVariable("userid") Long userId) {

        logger.info("getting studentId Done.");
        return userService.findUserById(userId);
    }

    @PostMapping("/saveUser")
    private Long saveUser(@RequestBody User user) throws Exception {
        logger.info("save User Done.");
        userService.saveUsers(user);
        return user.getId();

}
}
