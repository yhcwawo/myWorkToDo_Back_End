package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import payboocDev.myWorkToDo.model.Task;

import java.util.List;

@Mapper
public interface StaticMapper {

    @Select("SELECT * FROM WTD_TASK WHERE user_id=#{user_id}")
    Task getTaskSummary(@Param("user_id") int user_id);

    @Select(
            "select (select name from wtd_user where user_id = wtd_task.user_id limit 1) as name,\n" +
            "count(case when date_format(task_to_date, '%d') >= (date_format(now(), '%d') -4 ) then 1 end) as daypre4 \n" +
            ",count(case when date_format(task_to_date, '%d') >= (date_format(now(), '%d') -3 ) then 1 end) as daypre3 \n" +
            ",count(case when date_format(task_to_date, '%d') >= (date_format(now(), '%d') -2 ) then 1 end) as daypre2 \n" +
            ",count(case when date_format(task_to_date, '%d') >= (date_format(now(), '%d') -1 ) then 1 end) as daypre1 \n" +
            ",count(case when date_format(task_to_date, '%d') >= (date_format(now(), '%d')  ) then 1 end) as daytoday \n" +
            ",count(case when date_format(task_to_date, '%d') >= (date_format(now(), '%d') +1 ) then 1 end) as daypost1 \n" +
            ",count(case when date_format(task_to_date, '%d') >= (date_format(now(), '%d') +2 ) then 1 end) as daypost2 \n" +
            ",count(case when date_format(task_to_date, '%d') >= (date_format(now(), '%d') +3 ) then 1 end) as daypost3 \n" +
            ",count(case when date_format(task_to_date, '%d') >= (date_format(now(), '%d') +4 ) then 1 end)as daypost4 \n" +
            "from wtd_task\n" + "group by user_id")
    List<Task> getAllTaskStaticList(@Param("user_id") int user_id);
}
