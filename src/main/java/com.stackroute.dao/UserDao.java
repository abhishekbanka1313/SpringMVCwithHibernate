package com.stackroute.dao;

import com.stackroute.domain.User;

import java.util.List;

public interface UserDao {
    public boolean saveUser(User user);
    public List<User> getAllUser();
}
