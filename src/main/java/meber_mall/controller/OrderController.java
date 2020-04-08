package meber_mall.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import meber_mall.service.OrderService;

@Controller
public class OrderController extends UserBaseController{
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("addorder")
	public String addorder(HttpSession session,Double amount) {
		return orderService.addorder(session, amount);
	}
	
	@RequestMapping("selectorder")
	public String selectorder(Model model,HttpSession session){
		return orderService.selectorder(model, session);
	}
	
	@RequestMapping("confirmorder")
	public int confirmorder(Integer id,Double user_jf,Integer goods_id){
		return orderService.confirmorder(id, user_jf,goods_id);
	}
}
