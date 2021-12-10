package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payboocDev.myWorkToDo.mapper.GroupMapper;
import payboocDev.myWorkToDo.model.Group;

import java.util.List;

@RestController
@RequestMapping("/group")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials="true")
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

    @DeleteMapping("/{group_member}")
    public void deleteGroupMember(@PathVariable("group_member") int group_member) {
        groupMapper.deleteGroupMember(group_member);
    }
}
