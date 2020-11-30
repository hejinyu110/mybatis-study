package com.he.dao;

import com.he.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUserList();
    int addUser(User user);
    int addUser2(Map<String,Object> map);
    User getUser(int id);
    int updateUser(User user);
    int deleteUser(int id);

}
