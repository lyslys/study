package com.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Properties;

public class DBUtil {

	private static Properties props;

	private static Map ymlMap;

	static {


		//读取properties文件方法

	/*	try {
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("application.properties");
			props = new Properties();
			props.load(in);
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}*/

		//读取yml文件方法

		try {
			Yaml yaml = new Yaml();
			URL url = DBUtil.class.getClassLoader().getResource("application.yml");
			if (url != null) {
				//获取test.yaml文件中的配置数据，然后转换为obj，
				Object obj =yaml.load(new FileInputStream(url.getFile()));
//				System.out.println(obj);
				//也可以将值转换为Map
				ymlMap =(Map)yaml.load(new FileInputStream(url.getFile()));
//				System.out.println(ymlMap);
				//通过map我们取值就可以了.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

/*	public static Connection getConn() throws Exception{
		String url = props.getProperty("spring.datasource.url");
		String username = props.getProperty("spring.datasource.username");
		String password = props.getProperty("spring.datasource.password");
		String driver = props.getProperty("spring.datasource.driver-class-name");
		Class.forName(driver);
		return DriverManager.getConnection(url,username, password);
	}*/

	public static Connection getConnYml() throws Exception{
		Map  map = (Map)((Map)ymlMap.get("spring")).get("datasource");
		String url = map.get("url").toString();
		String username = map.get("username").toString();
		String password = map.get("password").toString();
		String driver = map.get("driver-class-name").toString();
		Class.forName(driver);
		return DriverManager.getConnection(url,username, password);
	}

	public static void main(String[] args) throws Throwable {
//		System.out.println(DBUtil.getConnYml());
//		System.out.println(((Map)((Map)ymlMap.get("spring")).get("datasource")).get("map"));
		System.out.println(DBUtil.getConnYml());
	}

}
