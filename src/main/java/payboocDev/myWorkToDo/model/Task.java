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


}
