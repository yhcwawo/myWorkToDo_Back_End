package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payboocDev.myWorkToDo.mapper.TaskMapper;
import payboocDev.myWorkToDo.model.Task;


import java.util.List;

@RestController
@RequestMapping("/task")
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
