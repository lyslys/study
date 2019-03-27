package com;

import com.mapper.test.StudentMapper;
import com.model.test.Dept;
import com.model.test.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication{


	@Autowired
	DataSource dataSource;

	@Autowired
	private StudentMapper studentMapper;

	@Test
	public void contextLoads() throws SQLException {
		//org.apache.tomcat.jdbc.pool.DataSource
//		System.out.println(dataSource.getClass());
//
//		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
//		connection.close();

//		System.out.println(studentMapper.query01(1));

//		Student student = studentMapper.query02(1);

		Student student = studentMapper.query03(1);
		System.out.println(student.getName());
//		System.out.println(student.getCls().getName());

	}

	@Test
	public void test() throws SQLException {
		Dept dept = studentMapper.query05();
		System.out.println(dept);
	}

}
