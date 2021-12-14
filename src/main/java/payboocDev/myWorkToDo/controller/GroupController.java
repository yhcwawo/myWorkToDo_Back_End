package payboocDev.myWorkToDo.controller;

import org.apache.ibatis.annotations.Param;
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
    public Group getGroupList(@PathVariable("id") int id) {
        return groupMapper.getGroupList(id);
    }

    //group page double query
    @GetMapping("/list/{group_member}")
    public List<Group> getAllGroupList(@PathVariable("group_member") int group_member) {
        return groupMapper.getAllGroupList(group_member);
    }

    //insert first
    @PostMapping("/post/master")
    public void insertGroupMaster(@RequestParam("group_name") String group_name, @RequestParam("auth") String auth,
                           @RequestParam("group_master") String group_master, @RequestParam("group_member") String group_member) {

        groupMapper.insertGroupMaster(group_name, auth, group_master, group_member);
    }

    //insert first
    @PostMapping("/post/member")
    public void insertGroupMember(@RequestParam("group_name") String group_name, @RequestParam("auth") String auth,
                           @RequestParam("group_master") String group_master, @RequestParam("group_member") String group_member,
                           @RequestParam("group_work_id") String group_work_id) {

        groupMapper.insertGroupMember(group_name, auth, group_master, group_member, group_work_id);
    }

    @DeleteMapping("/delete/{group_member}")
    public void deleteGroupMember(@PathVariable("group_member") int group_member) {
        groupMapper.deleteGroupMember(group_member);
    }
}
