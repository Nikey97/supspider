package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertyTest {
	
		public static void main(String[] args) {
			URL reUrl = PropertyTest.class.getClassLoader().getResource("db.properties");
			String apth = reUrl.toString().substring(6, reUrl.toString().length());
			System.out.println(apth);
			File file = new File(apth);
			try {
				InputStream inputStream = new FileInputStream(file);
				Properties properties = new Properties();	
				properties.load(inputStream);
				String driverClass = properties.getProperty("jdbc.driverClass");
				String jdbcUrl = properties.getProperty("jdbc.jdbcUrl");
				String user = properties.getProperty("jdbc.user");
				String psw = properties.getProperty("jdbc.psw");
				if (user != "") {
					System.out.println(user);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static String getPropertiesUrl() {
			boolean pass = true;
			URL reUrl = PropertyTest.class.getClassLoader().getResource("db.properties");
			String apth = reUrl.toString().substring(10, reUrl.toString().length());
			String a = apth.replace("!", "");
			System.out.println(a);
			File file = new File(a);
			try {
				InputStream inputStream = new FileInputStream(file);
				Properties properties = new Properties();	
				properties.load(inputStream);
				String driverClass = properties.getProperty("jdbc.driverClass");
				String jdbcUrl = properties.getProperty("jdbc.jdbcUrl");
				String user = properties.getProperty("jdbc.user");
				String psw = properties.getProperty("jdbc.psw");
				System.out.println(user);
				if (user == "") {
					pass = false;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return a;
		}
}
