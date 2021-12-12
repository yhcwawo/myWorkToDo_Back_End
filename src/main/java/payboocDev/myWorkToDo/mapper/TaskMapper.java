package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.*;
import payboocDev.myWorkToDo.model.Task;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("SELECT task_id, task_name, task_to_date, created_date, user_id, step, task_index, user_name, work_id, completedYn FROM WTD_TASK WHERE work_id=#{work_id}")
    List<Task> getTaskList(@Param("work_id") int work_id);

    //insert task
    @Insert("INSERT INTO WTD_WORK(task_name, task_to_date, created_date, user_id, step, task_index, user_name, work_id, completedYn ) VALUES(#{task_name}, #{task_to_date}, now(),#{user_id},#{step},#{task_index},#{user_name},#{work_id},#{completedYn})")
    int insertTask(@Param("task_name") String task_name, @Param("task_to_date") String task_to_date, @Param("user_id") int user_id, @Param("step") String step, @Param("task_index") int task_index, @Param("user_name") String user_name, @Param("work_id") String work_id, @Param("completedYn") String completedYn);

    //delete task
    @Delete("DELETE FROM WTD_TASK WHERE task_id=#{task_id}")
    int deleteTask(@Param("task_id") int task_id);

}
