package meber_mall.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import meber_mall.pojo.User;

public class MyUtil {
	public static String getStringID() {
		String id=null;
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		id=simpleDateFormat.format(date);
		return id;
	}
	
	//获取用户id(添加购物车时)储存数据
		public static Integer getUserId(HttpSession session) {
			User user=(User)session.getAttribute("user");
			if(user!=null){
				return user.getId();
			}
			else {
				return null;
			}
		}
}
