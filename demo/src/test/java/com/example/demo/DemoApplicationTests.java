package com.example.demo;

import com.example.demo.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("key", "value");
        redisTemplate.opsForValue().set("key2", "value2");
        Object key2 = redisTemplate.opsForValue().get("key2");
        System.out.println(key2);

    }

    @Test
    public void test1() throws JsonProcessingException {
        User user = new User("Zhoizw", 18);
        String json = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",json);
        Object user1 = redisTemplate.opsForValue().get("user");
        System.out.println(user1);
    }
}
