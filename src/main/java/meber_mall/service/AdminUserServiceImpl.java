package meber_mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import meber_mall.dao.AdminUserDao;
import meber_mall.pojo.User;
@Service
public class AdminUserServiceImpl implements AdminUserService {
	
	@Autowired
	private AdminUserDao adminUserDao;
	@Override
	public String userlist(Model model) {
		List<User>userlist=adminUserDao.userlist();
		model.addAttribute("userlist", userlist);
		return "selectuser";
	}

}
