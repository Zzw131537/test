package com.example.learnofmybatis.dao;


import com.example.learnofmybatis.pojo.User;
import com.example.learnofmybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UserDaoTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserList();

        User user1 = mapper.getUserById(1);
        System.out.println(user1.toString());
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(4,"Zhouzw4","123333"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(4,"zhou","123456"));

        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("userid","6");
        map.put("userName","zhouzw4");
        map.put("passWord","123456");
        mapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.getUserLikeByName("%zhou%");

        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test6() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList2 = mapper.getUserList2();
        for (User user : userList2) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
