package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.*;
import payboocDev.myWorkToDo.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM WTD_USER WHERE id=#{id}")
    User getUserProfile(@Param("id") int id);

    @Select("SELECT * FROM WTD_USER")
    List<User> getUserProfileList();

    @Insert("INSERT INTO WTD_USER(name,email,address) VALUES(#{name}, #{email}, #{address})")
    int insertUserProfile(@Param("name") String name, @Param("email") String email, @Param("address") String address);

    @Update("UPDATE WTD_USER SET name=#{name}, email=#{email}, address=#{address} WHERE id=#{id}")
    int updateUserProfile(@Param("id") int id, @Param("name") String name, @Param("email") String email, @Param("address") String address);

    @Delete("DELETE FROM WTD_USER WHERE id=#{id}")
    int deleteUserProfile(@Param("id") int id);


}
