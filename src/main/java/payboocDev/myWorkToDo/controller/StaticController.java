package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payboocDev.myWorkToDo.mapper.StaticMapper;
import payboocDev.myWorkToDo.model.Task;
import payboocDev.myWorkToDo.model.Work;

import java.util.List;

@RestController
@RequestMapping("/static")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials="true")
public class StaticController {

    @Autowired
    private StaticMapper staticMapper;


    //main summary static query
    @GetMapping("/main/{user_id}")
    public Task getTaskStaticList(@PathVariable("user_id") int user_id) {

        return staticMapper.getTaskStaticList(user_id);
    }


    //get all my Group static
    @GetMapping("/group/{user_id}")
    public List<Task> getAllMyWorkList(@PathVariable("user_id") int user_id) {
        return staticMapper.getAllTaskStaticList(user_id);
    }


}
