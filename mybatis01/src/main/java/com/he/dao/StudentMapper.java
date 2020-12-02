package com.he.dao;

import com.he.pojo.Student;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {

    @Select("select * from student")
    Student getStudentList();
}
