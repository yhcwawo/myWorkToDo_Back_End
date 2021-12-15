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
    public Task getTaskSummary(@PathVariable("user_id") int user_id) {
        return staticMapper.getTaskSummary(user_id);
    }

    //statistics total summary query
    @GetMapping("/total/{user_id}")
    public Task getTaskTotalSummary(@PathVariable("user_id") int user_id) {
        return staticMapper.getTaskTotalSummary(user_id);
    }

    //get all my Group static
    @GetMapping("/group/{user_id}")
    public List<Task> getAllMyWorkList(@PathVariable("user_id") int user_id) {
        return staticMapper.getAllTaskStaticList(user_id);
    }


}
