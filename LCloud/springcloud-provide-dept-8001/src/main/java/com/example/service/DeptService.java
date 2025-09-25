package com.example.service;

import java.util.List;
import com.example.springcloudapi.pojo.Dept;



public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept getDeptById(Long id);

    public List<Dept> getAllDepts();
}
