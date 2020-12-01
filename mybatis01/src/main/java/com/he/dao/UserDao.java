package com.he.dao;

import com.he.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    //通过注解写sql 语句，就不需要再  mapper.xml 文件中写对应的类信息了，
    // 但是需要再 mybatis-config.xml 文件中将类绑定上去
    @Select("select * from user")
    List<User> getUserList1();

    //方法有多个参数可以使用 @Params 注解 解析后的参数名称
    @Select("select * from user where id =#{id} and name =#{name}")
    User getUser(@Param("id") int id,@Param("name") String name);
}
