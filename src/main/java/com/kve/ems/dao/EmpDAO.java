package com.kve.ems.dao;

import com.kve.ems.entity.Emp;

import java.util.List;

public interface EmpDAO {
    List<Emp> findAll();
}
