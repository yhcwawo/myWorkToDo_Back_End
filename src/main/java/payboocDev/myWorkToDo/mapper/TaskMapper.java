package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.*;
import payboocDev.myWorkToDo.model.Task;
import payboocDev.myWorkToDo.model.Work;

import java.util.List;

@Mapper
public interface TaskMapper {

    //task info
    @Select("SELECT task_id, task_name, user_id, step, task_index, (select name from wtd_user where user_id = WTD_TASK.user_id ) as user_name, completedYn FROM WTD_TASK \n"+
            "where task_id = (select max(task_id) from wtd_task) ")
    Task getTaskInfo();

    //task list info
    @Select("SELECT task_id, task_name, task_to_date, date_format(created_date, '%Y-%m-%d')as created_date, user_id, step, task_index " +
            ",(select name from wtd_user where user_id = WTD_TASK.user_id ) as user_name\n" +
            ", work_id, completedYn FROM WTD_TASK WHERE work_id=#{work_id}")
    List<Task> getTaskList(@Param("work_id") int work_id);

    //insert task
    @Insert("INSERT INTO WTD_TASK(task_id, task_name, task_to_date, created_date, user_id, step, task_index, user_name, work_id, completedYn ) " +
            "VALUES(get_seq('task_sequence'), #{task_name}, #{task_to_date}, now(),#{user_id},#{step},#{task_index},#{user_name},#{work_id},#{completedYn})")
    int insertTask(@Param("task_name") String task_name, @Param("task_to_date") String task_to_date, @Param("user_id") int user_id,
                   @Param("step") String step, @Param("task_index") int task_index, @Param("user_name") String user_name, @Param("work_id") String work_id,
                   @Param("completedYn") String completedYn);

    //update task status
    @Update("UPDATE WTD_TASK SET completedYn=#{completedYn} WHERE task_id=#{task_id}")
    int updateTaskCompletedYn(@Param("task_id") String task_id, @Param("completedYn") String completedYn);

    //update task status
    @Update("UPDATE WTD_TASK SET step=#{step} WHERE task_id=#{task_id}")
    int updateTaskStep(@Param("task_id") String task_id, @Param("step") String step);

    //delete task
    @Delete("DELETE FROM WTD_TASK WHERE task_id=#{task_id}")
    int deleteTask(@Param("task_id") int task_id);

}
