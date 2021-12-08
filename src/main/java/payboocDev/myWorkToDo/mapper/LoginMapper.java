package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import payboocDev.myWorkToDo.model.User;

import java.util.List;

@Mapper
public interface LoginMapper {

    @Select("SELECT * FROM WTD_USER WHERE id=#{id}")
    User getLoginAuth(@Param("id") int id);


}
