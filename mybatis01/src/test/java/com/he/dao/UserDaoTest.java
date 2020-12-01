package com.he.dao;

import com.he.pojo.User;
import com.he.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDao.class);
    @Test
    public void test(){
        //获取 sql session 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user.getId()+user.getName()+user.getPwd());
        }
        sqlSession.close();
    }
    @Test
    public void addUser(){
       //获取sql session 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int hh = mapper.addUser(new User(5, "hh", "123"));
        sqlSession.commit();//所有的 增删改都需要  commit 提交事务才能生效
        sqlSession.close();
    }

    //使用map  对象绑定参数， xml 中只需要按照  map中定义的key 接受值就行，
    // 也可以接受一部分  必须更新部分字段
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",6);
        map.put("userName","666");
        map.put("userPwd","666");
        userDao.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void getUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUser(5);
        System.out.println(user.getName());
        sqlSession.close();;
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.updateUser(new User(2,"update","222"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int deleteUser = userDao.deleteUser(5);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void log4j(){
        logger.info("我是info");
        logger.debug("我是debug");
        logger.error("我是error");
    }
}
