package payboocDev.myWorkToDo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class Work {

    private int work_id;
    private String name;
    private String group_name;
    private int user_id;
    private String auth;
    private int group_number;
    private String group_master;
    private String team_name;
    private String created_date;
    private String to_date;


}
