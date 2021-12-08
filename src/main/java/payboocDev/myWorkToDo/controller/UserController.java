package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payboocDev.myWorkToDo.mapper.UserMapper;
import payboocDev.myWorkToDo.model.User;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials="true")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{user_id}")
    public User getUserProfile(@PathVariable("user_id") int user_id) {
        return userMapper.getUserProfile(user_id);
    }

    @GetMapping("/all")
    public List<User> getUserProfileList() {
        return userMapper.getUserProfileList();
    }

    @PutMapping("/{user_id}")
    public void putUserProfile(@PathVariable("user_id") int user_id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("team") String team, @RequestParam("password") String password) {
        userMapper.updateUserProfile(user_id, name, email, team, password);
    }

    @PostMapping("/post")
    public void postUserProfile(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("team") String team, @RequestParam("password") String password) {
        userMapper.insertUserProfile(name, email, team, password);
    }

    @DeleteMapping("/{user_id}")
    public void deleteUserProfile(@PathVariable("user_id") int user_id) {
        userMapper.deleteUserProfile(user_id);
    }



}
