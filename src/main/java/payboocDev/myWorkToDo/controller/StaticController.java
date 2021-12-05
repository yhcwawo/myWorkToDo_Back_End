package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payboocDev.myWorkToDo.mapper.StaticMapper;
import payboocDev.myWorkToDo.model.Task;

import java.util.List;

@RestController
@RequestMapping("/static")
public class StaticController {

    @Autowired
    private StaticMapper staticMapper;

    @GetMapping("/{id}")
    public Task getWorkList(@PathVariable("id") int id) {

        return staticMapper.getTaskStaticList(id);
    }

    @GetMapping("/all")
    public List<Task> getUserProfileList() {

        return staticMapper.getAllTaskStaticList();
    }


}
