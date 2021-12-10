package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.*;
import payboocDev.myWorkToDo.model.Group;

import java.util.List;

@Mapper
public interface GroupMapper {

    @Select("SELECT * FROM WTD_GROUP WHERE id=#{id}")
    Group getGroupList(@Param("id") int id);

    @Select("SELECT * FROM WTD_GROUP")
    List<Group> getAllGroupList();

    //insert group master at first
    @Insert("INSERT INTO WTD_GROUP(name,group_name,user_id,auth,group_number,group_master,team_name,created_date,to_date ) VALUES(#{name}, #{group_name}, #{user_id},#{auth},#{group_number},#{group_master},#{team_name},NOW(), #{to_date})")
    int insertGroupMaster(@Param("name") String name, @Param("group_name") String group_name, @Param("user_id") String user_id,@Param("auth") String auth,@Param("group_number") String group_number,@Param("group_master") String group_master,@Param("team_name") String team_name,@Param("to_date") String to_date);

    //insert group member in group page
    @Insert("INSERT INTO WTD_GROUP(name,group_name,user_id,auth,group_number,group_master,team_name,created_date,to_date ) VALUES(#{name}, #{group_name}, #{user_id},#{auth},#{group_number},#{group_master},#{team_name},NOW(), #{to_date})")
    int insertGroupMember(@Param("name") String name, @Param("group_name") String group_name, @Param("user_id") String user_id,@Param("auth") String auth,@Param("group_number") String group_number,@Param("group_master") String group_master,@Param("team_name") String team_name,@Param("to_date") String to_date);

    //delete group member
    @Delete("DELETE FROM WTD_GROUP WHERE group_member=#{group_member}")
    int deleteGroupMember(@Param("group_member") int group_member);



}
