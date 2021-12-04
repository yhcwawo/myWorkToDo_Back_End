package payboocDev.myWorkToDo.model;

import lombok.Data;

//lombok 호출 어노테이션
//getter setter 안해줘도 java beans 인식
@Data
public class User {

    private int id;
    private String name;
    private String email;
    private String address;


}
