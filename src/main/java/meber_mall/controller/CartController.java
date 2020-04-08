package meber_mall.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import meber_mall.service.CartService;

@Controller
public class CartController extends UserBaseController{
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("putCart")
	public String putCart(Integer id,Integer shopnum,HttpSession session,Model model) {
		return cartService.putCart(id, shopnum, session, model);
	}
	
	@RequestMapping("selectCart")
	public String selectCart(Model model,HttpSession session,String act){
		return cartService.selectcart(model, session,act);
	}
	
	@RequestMapping("clearCart")
	public String clearCart(HttpSession session) {
		return cartService.clearCart(session);
	}
	
	@RequestMapping("addordecrease")
	public List<Map<String, Object>>addordecrease(Integer id, Integer user_id, String torf){
		return cartService.addordecrease(id, user_id, torf);
	}
	
	@RequestMapping("checkorder")
	public List<Map<String, Object>>checkorder(@RequestBody List<Integer>ids,Integer user_id){
		System.out.println(ids);
		return cartService.chechorder(ids,user_id);
	}
	
	@RequestMapping("deleteAgoods")
	public String deleteAgoods(HttpSession session,Integer goods_id) {
		return cartService.deleteAgoods(session,goods_id);
	}
}
