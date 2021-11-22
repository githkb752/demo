package cn.nskjy.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public static final long serialVersionUID = 1L;
    private String uname;
    private Integer age;
    private char gender;
}
