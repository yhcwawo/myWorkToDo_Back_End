package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.*;
import payboocDev.myWorkToDo.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT user_id, name, team, email, date_format(created_date, '%Y-%m-%d')as created_date FROM WTD_USER WHERE user_id=#{user_id}")
    User getUserProfile(@Param("user_id") int user_id);

    @Select("SELECT * FROM WTD_USER WHERE name=#{name}, password=#{password}")
    User getLoginUserAuth(@Param("name") String name,@Param("password") String password);

    @Select("SELECT * FROM WTD_USER")
    List<User> getUserProfileList();

    @Insert("INSERT INTO WTD_USER(name,password,team, email, created_date) VALUES(#{name}, #{password}, #{team}, #{email}, now())")
    int insertUserProfile(@Param("name") String name, @Param("password") String password, @Param("email") String email,@Param("team") String team   );

    @Update("UPDATE WTD_USER SET name=#{name}, email=#{email}, team=#{team} , password=#{password} WHERE user_id=#{user_id}")
    int updateUserProfile(@Param("user_id") int user_id, @Param("name") String name, @Param("email") String email, @Param("team") String team, @Param("password") String password);

    @Delete("DELETE FROM WTD_USER WHERE id=#{id}")
    int deleteUserProfile(@Param("user_id") int user_id);


}
