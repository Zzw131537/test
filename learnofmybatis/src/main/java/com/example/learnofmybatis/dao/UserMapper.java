package com.example.learnofmybatis.dao;

import com.example.learnofmybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 查询用户列表
    List<User> getUserList();

    // 根据id 查询用户信息
    User getUserById(int id);

    // 插入用户
    void addUser(User user);

    // 万能Map
    int addUser2(Map<String, Object> map);
    // 更新用户
    void updateUser(User user);

    // 模糊查询
    List<User>getUserLikeByName(String name);

    @Select("select * from user")
    List<User> getUserList2();
}
