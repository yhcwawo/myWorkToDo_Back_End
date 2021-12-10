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

    @GetMapping("/{work_id}")
    public Task getWorkList(@PathVariable("work_id") int work_id) {
        return taskMapper.getTaskList(work_id);
    }

    @GetMapping("/all")
    public List<Task> getUserProfileList() {
        return taskMapper.getAllTaskList();
    }

    @DeleteMapping("/{task_id}")
    public void deleteWork(@PathVariable("task_id") int task_id) {
        taskMapper.deleteTask(task_id);
    }
}
