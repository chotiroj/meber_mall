package meber_mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mysql.jdbc.log.Log;

import meber_mall.exception.UserLoginNoException;

@Controller
public class UserBaseController {
	@ModelAttribute
	public void idlogin(HttpSession session,HttpServletRequest request)throws UserLoginNoException{
		if(session.getAttribute("user")==null) {
			System.out.println("您还未登录！");
			throw new UserLoginNoException("没有登录");
		}
	}
}
