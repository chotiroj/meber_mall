package meber_mall.service;


import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface OrderService {
	public String addorder(HttpSession session,Double amount);
	public String selectorder(Model model,HttpSession session);
	public int confirmorder(Integer id,Double user_jf,Integer goods_id);
}
