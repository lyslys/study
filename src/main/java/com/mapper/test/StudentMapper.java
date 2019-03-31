package com.mapper.test;

import com.model.test.Dept;
import com.model.test.Student;
import org.apache.ibatis.annotations.MapKey;

public interface StudentMapper {

    Student getStudentById(Integer id);

    Student query01(Integer id);

    Student query02(Integer id);

    Student query03(Integer id);

    @MapKey("deptno")
    Dept query05();

}
