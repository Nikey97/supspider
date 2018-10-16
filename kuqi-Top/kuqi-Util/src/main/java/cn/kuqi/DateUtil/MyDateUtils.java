package cn.kuqi.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtils {
	
	
	//获取系统当前时间
	public String getSystemNowTime(String DateFormat) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat);//时间格式yyyy年MM月dd日 HH时mm分ss秒
		String time = simpleDateFormat.format(date);//获取系统当前时间
		return time;
	}
}
