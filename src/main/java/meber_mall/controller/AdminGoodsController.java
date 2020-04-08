package meber_mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import meber_mall.pojo.Goods;
import meber_mall.service.AdminGoodsService;
import meber_mall.service.AdminService;

@Controller
@RequestMapping("admin")
public class AdminGoodsController {

	@Autowired
	private AdminGoodsService adminGoodsService;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("main")
	public String main(Model model) {
		return adminGoodsService.seleteallgoods(model);
	}
	
	@RequestMapping("toaddGoods")
	public String toaddGoods(HttpSession session) {
		return adminService.main(session);
	}
	
	@RequestMapping("addGoods")
	public String addGoods(@ModelAttribute Goods goods ,HttpServletRequest request){
		return adminGoodsService.addGoods(goods, request);
		
	}
	
	@RequestMapping("search")
	public String search(String key,Model model) {
		return adminGoodsService.seleteGoods(key, model);
	}
	
	@RequestMapping("deleteAgoods")
	public String deleteAgoods(Integer id){
		return adminGoodsService.deleteAgoods(id);
	}
	
	@RequestMapping("updateselectAgoods")
	public String updateselectAgoods(Integer id,Model model) {
		return adminGoodsService.selectAgoods(id, model);
	}
	
	@RequestMapping("updateAgoods")
	public String updateAgoods(@ModelAttribute Goods goods,HttpServletRequest request) {
		return adminGoodsService.updateAgoods(goods, request);
	}
	
	@RequestMapping("selectType")
	public String selectType(Model model) {
		return adminGoodsService.selectType(model);
	}
	
	@RequestMapping("selectbyname")
	public String selectbyname(Model model,String key) {
		return adminGoodsService.selectlike(model, key);
	}
	
	@RequestMapping("toaddType")
	public String toaddType(){
		return "addType";
	}
	
	@RequestMapping("addType")
	public String addType(String typename) {
		return adminGoodsService.addType(typename);
	}
	
	@RequestMapping("deleteType")
	public String deleteType(Integer id) {
		return adminGoodsService.deleteType(id);
	}
}
