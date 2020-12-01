package com.he.dao;

import com.he.pojo.User;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Map;

//通过注解 使用类别名， mybatis-config 设置包的别名后可以直接用这个名字
@Alias("UserDao")
public interface UserDao {
    List<User> getUserList();
    int addUser(User user);
    int addUser2(Map<String,Object> map);
    User getUser(int id);
    int updateUser(User user);
    int deleteUser(int id);
    List<User> getUserByLimit(Map<String,Object> map);
}
