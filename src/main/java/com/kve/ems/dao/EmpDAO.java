package com.kve.ems.dao;

import com.kve.ems.entity.Emp;

import java.util.List;

public interface EmpDAO {
    List<Emp> findAll();

    void save(Emp emp);

    void delete(String id);

    Emp find(String id);

    void update(Emp emp);
}
