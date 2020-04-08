package meber_mall.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meber_mall.dao.AdminGoosTypeDao;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminGoosTypeDao adminGoosTypeDao;
	@Override
	public String main(HttpSession session) {
		session.setAttribute("goodstype", adminGoosTypeDao.selectType());
		return "addGoods";
	}

}
