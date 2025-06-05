package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private int id;
    private String name;
    private String email;
    private int age;
    private String password;
}





