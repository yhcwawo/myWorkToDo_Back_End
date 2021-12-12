package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.*;
import payboocDev.myWorkToDo.model.Group;

import java.util.List;

@Mapper
public interface GroupMapper {

    @Select("SELECT * FROM WTD_GROUP WHERE id=#{id}")
    Group getGroupList(@Param("id") int id);

    @Select("SELECT group_id, group_name, auth, group_master, group_member, group_work_id\n" +
            "FROM wtd_group\n" +
            "where group_member = #{group_member}\n")
    List<Group> getAllGroupList(@Param("group_member") int group_member);

    //insert group master at first
    @Insert("INSERT INTO WTD_GROUP(group_name, auth, group_master, group_member, group_work_id ) VALUES(#{group_name}, #{auth}, #{group_master},#{group_member},#{group_work_id})")
    int insertGroupMaster(@Param("group_name") String group_name, @Param("auth") String auth, @Param("group_master") String group_master, @Param("group_member") String group_member, @Param("group_work_id") String group_work_id);

    //insert group member in group page
    @Insert("INSERT INTO WTD_GROUP(group_name, auth, group_master, group_member, group_work_id ) VALUES(#{group_name}, #{auth}, #{group_master},#{group_member},#{group_work_id})")
    int insertGroupMember(@Param("group_name") String group_name, @Param("auth") String auth, @Param("group_master") String group_master, @Param("group_member") String group_member, @Param("group_work_id") String group_work_id);




    //delete group member
    @Delete("DELETE FROM WTD_GROUP WHERE group_member=#{group_member}")
    int deleteGroupMember(@Param("group_member") int group_member);



}
