package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payboocDev.myWorkToDo.mapper.TaskMapper;
import payboocDev.myWorkToDo.model.Task;


import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials="true")
public class TaskController {

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping("/{id}")
    public Task getWorkList(@PathVariable("id") int id) {
        return taskMapper.getTaskList(id);
    }

    @GetMapping("/all")
    public List<Task> getUserProfileList() {
        return taskMapper.getAllTaskList();
    }
}
