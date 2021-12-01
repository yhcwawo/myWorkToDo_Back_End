package payboocDev.myWorkToDo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USER(user_name, user_address) VALUES(#{user.name}, #{user.address})")
    int insert(@Param("user") User user);

}
