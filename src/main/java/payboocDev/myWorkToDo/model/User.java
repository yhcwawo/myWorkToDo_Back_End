package payboocDev.myWorkToDo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//lombok 호출 어노테이션
//java beans 자동 인식
//getter setter에서 해방되기
@Getter
@Setter
@ToString
@Data
public class User {

    private int user_id;
    private String name;
    private String team;
    private String email;
    private String created_date;
    private String password;
}
