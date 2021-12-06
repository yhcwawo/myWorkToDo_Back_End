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

    @GetMapping("/{id}")
    public User getUserProfile(@PathVariable("id") int id) {
        return userMapper.getUserProfile(id);
    }

    @GetMapping("/all")
    public List<User> getUserProfileList() {
        return userMapper.getUserProfileList();
    }

    @PutMapping("/{id}")
    public void putUserProfile(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("address") String address) {
        userMapper.updateUserProfile(id, name, email, address);
    }

    @PostMapping("/post")
    public void postUserProfile(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("address") String address) {
        userMapper.insertUserProfile(name, email, address);
    }

    @DeleteMapping("/{id}")
    public void deleteUserProfile(@PathVariable("id") int id) {
        userMapper.deleteUserProfile(id);
    }



}
