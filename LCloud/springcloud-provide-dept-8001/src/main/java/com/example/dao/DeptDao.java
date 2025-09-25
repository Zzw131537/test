package com.example.dao;

import com.example.springcloudapi.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept getDeptById(Long id);

    public List<Dept> getAllDepts();
}

