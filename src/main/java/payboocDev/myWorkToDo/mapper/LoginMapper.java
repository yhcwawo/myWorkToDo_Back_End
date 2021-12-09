package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import payboocDev.myWorkToDo.model.User;

import java.util.List;

@Mapper
public interface LoginMapper {

    @Select("SELECT TRUE FROM WTD_USER WHERE name=#{name},  password=#{password}")
    User getLoginAuth(@Param("name") String name,@Param("password") String password);

    @Select("SELECT FALSE FROM WTD_USER")
    User getLogoutAuth(@Param("user_id") int user_id);

}
