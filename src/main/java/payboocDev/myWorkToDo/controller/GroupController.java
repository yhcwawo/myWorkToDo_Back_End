package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payboocDev.myWorkToDo.mapper.GroupMapper;
import payboocDev.myWorkToDo.model.Group;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupMapper groupMapper;

    @GetMapping("/{id}")
    public Group getWorkList(@PathVariable("id") int id) {
        return groupMapper.getGroupList(id);
    }

    @GetMapping("/all")
    public List<Group> getUserProfileList() {
        return groupMapper.getAllGroupList();
    }
}
