package payboocDev.myWorkToDo.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payboocDev.myWorkToDo.mapper.WorkMapper;
import payboocDev.myWorkToDo.model.User;
import payboocDev.myWorkToDo.model.Work;

import java.util.List;

@RestController
@RequestMapping("/work")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials="true")
public class WorkController {

    @Autowired
    private WorkMapper workMapper;

    //work info
    @GetMapping("/{work_id}")
    public Work getWorkInfo(@PathVariable("work_id") int work_id) {
        return workMapper.getWorkInfo(work_id);
    }

    //get all my work list
    @GetMapping("/workList/{user_id}")
    public List<Work> getAllMyWorkList(@PathVariable("user_id") int user_id) {
        return workMapper.getAllMyWorkList(user_id);
    }

    //get recent my work list
    @GetMapping("/recent/{user_id}")
    public List<Work> getRecentWorkList(@PathVariable("user_id") int user_id) {

        return workMapper.getRecentWorkList(user_id);
    }


    @PutMapping("/{id}")
    public void updateWork(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("address") String address) {
        workMapper.updateWork(id, name, email, address);
    }

    @PostMapping("/post")
    public void insertWork(@RequestParam("name") String name, @RequestParam("group_name") String group_name,
                           @RequestParam("user_id") int user_id, @RequestParam("auth") String auth,
                           @RequestParam("group_number") int group_number, @RequestParam("group_master") String group_master,
        @RequestParam("team_name") String team_name, @RequestParam("to_date") String to_date ) {

            workMapper.insertWork(name, group_name, user_id,auth,group_number,group_master, team_name,to_date);
    }

    @DeleteMapping("/{id}")
    public void deleteWork(@PathVariable("id") int id) {
        workMapper.deleteWork(id);
    }


}
