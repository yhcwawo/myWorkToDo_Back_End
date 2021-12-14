package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payboocDev.myWorkToDo.mapper.UserMapper;
import payboocDev.myWorkToDo.model.User;
import payboocDev.myWorkToDo.model.Work;

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

    @GetMapping("/login")
    public User getLoginUserAuth(@PathVariable("name") String name, @PathVariable("password") String password) {
        return userMapper.getLoginUserAuth(name, password);
    }

    @GetMapping("/name")
    public List<User> getUserProfileList() {
        return userMapper.getUserProfileList();
    }

    @PutMapping("/{user_id}")
    public void putUserProfile(@PathVariable("user_id") int user_id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("team") String team, @RequestParam("password") String password) {
        userMapper.updateUserProfile(user_id, name, email, team, password);
    }

    @PostMapping("/post")
    public void postUserProfile(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("team") String team) {
        userMapper.insertUserProfile(name, password, email, team );
    }

    @DeleteMapping("/{user_id}")
    public void deleteUserProfile(@PathVariable("user_id") int user_id) {
        userMapper.deleteUserProfile(user_id);
    }



}
