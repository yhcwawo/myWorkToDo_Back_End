package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payboocDev.myWorkToDo.mapper.LoginMapper;
import payboocDev.myWorkToDo.model.User;

import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials="true")
public class LoginController {

    @Autowired
    private LoginMapper loginMapper;

    @GetMapping("/login")
    public User getLogininfo(@PathVariable("id") int id) {
        return loginMapper.getLoginAuth(id);
    }


}
