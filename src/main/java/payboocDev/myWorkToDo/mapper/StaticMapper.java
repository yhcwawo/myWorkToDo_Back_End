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

    @Select("SELECT * FROM WTD_TASK WHERE user_id=#{user_id}")
    List<Task> getAllTaskStaticList(@Param("user_id") int user_id);
}
