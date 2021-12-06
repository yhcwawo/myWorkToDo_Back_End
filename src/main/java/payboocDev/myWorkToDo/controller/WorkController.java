package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payboocDev.myWorkToDo.mapper.WorkMapper;
import payboocDev.myWorkToDo.model.Work;

import java.util.List;

@RestController
@RequestMapping("/work")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials="true")
public class WorkController {

    @Autowired
    private WorkMapper workMapper;

    @GetMapping("/{id}")
    public Work getWorkList(@PathVariable("id") int id) {
        return workMapper.getWorkList(id);
    }

    @GetMapping("/all")
    public List<Work> getUserProfileList() {
        return workMapper.getWorkAllList();
    }

    @PutMapping("/{id}")
    public void putUserProfile(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("address") String address) {
        workMapper.updateWork(id, name, email, address);
    }

    @PostMapping("/post")
    public void postUserProfile(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("address") String address) {
        workMapper.insertWork(name, email, address);
    }

    @DeleteMapping("/{id}")
    public void deleteUserProfile(@PathVariable("id") int id) {
        workMapper.deleteWork(id);
    }


}
