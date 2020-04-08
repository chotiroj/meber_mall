package meber_mall.service;


import javax.servlet.http.HttpSession;

import meber_mall.pojo.User;

public interface UserService {
	public String userlogin(User user,HttpSession session);
	public String userregister(User user,HttpSession session);
}
