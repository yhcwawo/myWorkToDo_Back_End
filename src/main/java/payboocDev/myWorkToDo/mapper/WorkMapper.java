package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.*;
import payboocDev.myWorkToDo.model.Work;

import java.util.List;

@Mapper
public interface WorkMapper {

    @Select("SELECT * FROM WTD_WORK WHERE user_id=#{id}")
    Work getWorkList(@Param("id") int id);

    @Select("SELECT * FROM WTD_WORK WHERE id=#{id}")
    Work getWorkDetail(@Param("id") int id);

    @Select("SELECT * FROM WTD_WORK")
    List<Work> getWorkAllList();

    @Insert("INSERT INTO WTD_WORK(name,email,address) VALUES(#{name}, #{email}, #{address})")
    int insertWork(@Param("name") String name, @Param("email") String email, @Param("address") String address);

    @Update("UPDATE WTD_WORK SET name=#{name}, email=#{email}, address=#{address} WHERE id=#{id}")
    int updateWork(@Param("id") int id, @Param("name") String name, @Param("email") String email, @Param("address") String address);

    @Delete("DELETE FROM WTD_WORK WHERE id=#{id}")
    int deleteWork(@Param("id") int id);


}
