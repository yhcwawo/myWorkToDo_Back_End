package payboocDev.myWorkToDo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class Group {

    //group
    private int group_id;
    private int group_member;
    private int group_work_id;
    private String group_name;
    private String auth;
    private String group_master;
    private String group_master_name;
    private String group_member_name;

    //work
    private int id;
    private int work_id;
    private String name;
    private String created_date;
    private String to_date;
    private String group_number;

}
