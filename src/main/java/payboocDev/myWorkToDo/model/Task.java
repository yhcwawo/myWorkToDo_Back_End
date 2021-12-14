package payboocDev.myWorkToDo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class Task {

    private int task_id;
    private String task_name;
    private String task_to_date;
    private String created_date;
    private int user_id;
    private int work_id;
    private String step;
    private int task_index;
    private String user_name;
    private String completedYn;

    //static part
    private String daypre4;
    private String daypre3;
    private String daypre2;
    private String daypre1;
    private String daytoday;
    private String daypost1;
    private String daypost2;
    private String daypost3;
    private String daypost4;
    private String name;


}
