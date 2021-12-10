package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import payboocDev.myWorkToDo.model.Task;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("SELECT task_id, task_name, task_to_date, created_date, user_id, step, task_index, user_name, work_id FROM WTD_TASK WHERE work_id=#{work_id}")
    Task getTaskList(@Param("work_id") int work_id);

    @Select("SELECT task_id, task_name, task_to_date, created_date, user_id, step, task_index, user_name, work_id FROM WTD_TASK")
    List<Task> getAllTaskList();


    //delete task
    @Delete("DELETE FROM WTD_TASK WHERE task_id=#{task_id}")
    int deleteTask(@Param("task_id") int task_id);

}
