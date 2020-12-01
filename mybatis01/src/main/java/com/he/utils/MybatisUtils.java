package com.he.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //sqlsession 获取实例
    public static SqlSession getSqlSession(){
        //默认是不开启事务自动提交的，如果设置为true 以后就不用每次都手动提交 默认是false
//        return sqlSessionFactory.openSession(true);
        return sqlSessionFactory.openSession(true);
    }
}
