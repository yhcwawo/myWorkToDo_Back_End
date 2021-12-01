package payboocDev.myWorkToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserMapper userMapper;

    @PostMapping("")
    public int post(@RequestBody User user){
        return userMapper.insert(user);
    };


}
