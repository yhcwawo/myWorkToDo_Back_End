package payboocDev.myWorkToDo.mapper;

import org.apache.ibatis.annotations.*;
import payboocDev.myWorkToDo.model.Group;

import java.util.List;

@Mapper
public interface GroupMapper {

    @Select("SELECT * FROM WTD_GROUP WHERE id=#{id}")
    Group getGroupList(@Param("id") int id);

    @Select("SELECT groupT.group_work_id, groupT.group_id, groupT.group_id as id , groupT.group_name,  groupT.auth , groupT.group_master , groupT.group_member, workT.name,\n" +
            "date_format(workT.created_date, '%Y-%m-%d') as created_date ,date_format(workT.to_date, '%Y-%m-%d') as to_date\n" +
            ",(select count(*) as group_number from wtd_group where group_id = groupT.group_id) as group_number\n" +
            ",(select name from wtd_user where user_id = groupT.group_master ) as group_master_name\n" +
            ",(select name from wtd_user where user_id = groupT.group_member ) as group_member_name\n" +
            "FROM wtd_work as workT LEFT JOIN wtd_group as groupT ON workT.work_id = groupT.group_work_id \n" +
            "where groupT.group_member = #{group_member}")
    List<Group> getAllGroupList(@Param("group_member") int group_member);

    //insert group master at first
    @Insert("INSERT INTO WTD_GROUP(group_name, auth, group_master, group_member, group_work_id ) VALUES(#{group_name}, #{auth}, #{group_master},#{group_member},get_seq('work_sequence') )")
    int insertGroupMaster(@Param("group_name") String group_name, @Param("auth") String auth, @Param("group_master") String group_master, @Param("group_member") String group_member);

    //insert group member in group page
    @Insert("INSERT INTO WTD_GROUP(group_name, auth, group_master, group_member, group_work_id ) VALUES(#{group_name}, #{auth}, #{group_master},#{group_member},#{group_work_id})")
    int insertGroupMember(@Param("group_name") String group_name, @Param("auth") String auth, @Param("group_master") String group_master, @Param("group_member") String group_member, @Param("group_work_id") String group_work_id);


    //delete group member
    @Delete("DELETE FROM WTD_GROUP WHERE group_member=#{group_member}")
    int deleteGroupMember(@Param("group_member") int group_member);



}
