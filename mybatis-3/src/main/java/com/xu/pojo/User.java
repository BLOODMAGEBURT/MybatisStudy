package com.xu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年08月12日 16:28:00
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private String pwd;

}
