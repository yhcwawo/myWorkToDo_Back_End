package payboocDev.myWorkToDo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class Comment {

    private int comment_id;
    private String payload;
    private String created_date;
    private String user_id;
    private String user_name;


}
