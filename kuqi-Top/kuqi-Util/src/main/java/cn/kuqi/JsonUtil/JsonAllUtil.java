package cn.kuqi.JsonUtil;

import com.google.gson.Gson;

public class JsonAllUtil {
		
		/*
		 * 	pojo转化成json的方法
		 * 	
		 * 		coding time: 2018 10 13 20:55 
		 * */
		public String PojoToJson(Object object) {
			Gson gson = new Gson();
			return gson.toJson(object);
		}
}
