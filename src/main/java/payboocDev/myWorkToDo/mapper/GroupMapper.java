package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import payboocDev.myWorkToDo.model.Group;

import java.util.List;

@Mapper
public interface GroupMapper {

    @Select("SELECT * FROM WTD_GROUP WHERE id=#{id}")
    Group getGroupList(@Param("id") int id);

    @Select("SELECT * FROM WTD_GROUP")
    List<Group> getAllGroupList();

}
