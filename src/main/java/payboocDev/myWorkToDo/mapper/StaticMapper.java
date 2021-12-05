package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import payboocDev.myWorkToDo.model.Task;

import java.util.List;

@Mapper
public interface StaticMapper {

    @Select("SELECT * FROM WTD_TASK WHERE id=#{id}")
    Task getTaskStaticList(@Param("id") int id);

    @Select("SELECT * FROM WTD_TASK")
    List<Task> getAllTaskStaticList();
}
