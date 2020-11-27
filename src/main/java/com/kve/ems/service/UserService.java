package com.kve.ems.service;

import com.kve.ems.entity.User;

public interface UserService {
    void register(User user);

    User login(String username, String password);
}
