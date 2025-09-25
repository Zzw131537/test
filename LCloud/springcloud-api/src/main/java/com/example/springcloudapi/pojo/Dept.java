package com.example.springcloudapi.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) // 链式写法
public class Dept implements Serializable { // 实体类

    private Long deptno;
    private String dname;
    // 这个数据是存在那个数据库的
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }


}
