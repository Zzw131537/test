package com.example.service;


import com.example.dao.DeptDao;
import com.example.springcloudapi.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
      return deptDao.addDept(dept);
    }

    @Override
    public Dept getDeptById(Long id) {
        return deptDao.getDeptById(id);
    }

    @Override
    public List<Dept> getAllDepts() {
        return deptDao.getAllDepts();
    }
}
