package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Author: Zhouzw
 * Date: 2025/5/26 22:27
 */

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String name;
    private int age;
}
