package cn.kuqi.test;

import java.net.URL;
import java.util.Properties;

public class PropertyTest {
	
		public static void main(String[] args) {
			URL reUrl = PropertyTest.class.getClassLoader().getResource("db.properties");
			String path = reUrl.toString();
			System.out.println(path);
		}
}
