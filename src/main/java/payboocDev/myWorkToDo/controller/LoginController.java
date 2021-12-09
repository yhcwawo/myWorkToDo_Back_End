package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payboocDev.myWorkToDo.mapper.LoginMapper;
import payboocDev.myWorkToDo.model.User;

@RestController
@RequestMapping("/login")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials="true")
public class LoginController {

    @Autowired
    private LoginMapper loginMapper;

    @GetMapping("/login")
    public User getLogins(@PathVariable("name") String name,@PathVariable("password") String password) {

        return loginMapper.getLoginAuth(name,password);
    }

    @GetMapping("/logout")
    public User getLogins(@PathVariable("user_id") int user_id) {

        return loginMapper.getLogoutAuth(user_id);
    }





}
