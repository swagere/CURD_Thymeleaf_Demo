package com.kve.ems.dao;

import com.kve.ems.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserDAO {
    void save(User user);

    User login(@Param("username") String username, @Param("password") String password);
}
