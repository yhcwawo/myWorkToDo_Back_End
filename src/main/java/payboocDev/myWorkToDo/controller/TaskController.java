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
    public List<Task> getTaskList(@PathVariable("work_id") int work_id) {
        return taskMapper.getTaskList(work_id);
    }

    @PostMapping("/post")
    public void insertTask(@RequestParam("task_name") String task_name, @RequestParam("task_to_date") String task_to_date,
                           @RequestParam("user_id") int user_id, @RequestParam("step") String step,
                           @RequestParam("task_index") int task_index, @RequestParam("user_name") String user_name,
                           @RequestParam("work_id") String work_id, @RequestParam("completedYn") String completedYn ) {

        taskMapper.insertTask(task_name, task_to_date, user_id, step, task_index, user_name, work_id, completedYn );
    }

    @DeleteMapping("/delete/{task_id}")
    public void deleteTask(@PathVariable("task_id") int task_id) {
        taskMapper.deleteTask(task_id);
    }
}
