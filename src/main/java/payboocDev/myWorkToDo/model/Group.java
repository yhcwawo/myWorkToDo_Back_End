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

    private int group_id;
    private int group_member;
    private int group_work_id;
    private String group_name;
    private String auth;
    private String group_master;

}
