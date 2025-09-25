package com.example.controller;

import com.example.service.DeptService;
import com.example.springcloudapi.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDeptById(@PathVariable("id") Long id) {
        return deptService.getDeptById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> getDepts() {
     return deptService.getAllDepts();
    }

}
