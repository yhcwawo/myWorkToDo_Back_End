package payboocDev.myWorkToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payboocDev.myWorkToDo.mapper.WorkMapper;

@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkMapper workMapper;
}
