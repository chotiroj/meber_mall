package meber_mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import meber_mall.service.AdminUserService;

@Controller
public class AdminUserController {
	@Autowired
	private AdminUserService adminUserService;
	
	@RequestMapping("selectuser")
	public String selectuser(Model model) {
		return adminUserService.userlist(model);
	}
}
