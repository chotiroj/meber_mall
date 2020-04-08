package meber_mall.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import meber_mall.pojo.User;
import meber_mall.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("toregister")
	public String toregister() {
		return "before/register";
	}
	
	@RequestMapping("register")
	public String register(@ModelAttribute User user,HttpSession session) {
		return userService.userregister(user, session);
	}
	
	@RequestMapping("tologin")
	public String tologin() {
		return "before/login";
	}
	
	@RequestMapping("login")
	public String login(@ModelAttribute User user,HttpSession session) {
		return userService.userlogin(user, session);
	}
	
	@RequestMapping("exit")
	public String exit(HttpSession session){
		session.invalidate();
		return "forward:index";
	}
	
	@RequestMapping("touserCenter")
	public String touserCenter() {
		return "forward:selectorder";
	}
}
