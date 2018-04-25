package cn.supspider.Utils;

import java.util.List;

import net.sf.json.JSONArray;

public class ToJsonType {
		//List转Json工具类
		public JSONArray List2Json(List<?> list) {
			JSONArray json=JSONArray.fromObject(list);
			return json;
		}
}
