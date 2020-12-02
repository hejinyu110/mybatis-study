package com.he.dao;

import com.he.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("select * from teacher")
    Teacher getTeacherList();
}
