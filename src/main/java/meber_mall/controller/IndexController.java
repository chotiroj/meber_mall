package meber_mall.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import meber_mall.pojo.Goods;
import meber_mall.service.IndexService;

@Controller
public class IndexController {
	@Autowired
	private IndexService indexService;
	@RequestMapping("index")
	public String index(Model model,Goods goods,HttpSession session) {
		return indexService.index(model, goods,session);
	}
	@RequestMapping("goodsdetail")
	public String goodsdetail(HttpSession session,Integer id,Model model) {
		return indexService.goodsdetail(session,id, model);
	}
	
	@RequestMapping("goodsnav")
	public String putCart() {
		return "before/product-grid";
	}
	
	@RequestMapping("search")
	public String goodsList(String gsname,Model model) {
		return indexService.search(gsname, model);
	}
	
	@RequestMapping("about-us")
	public String aboutUs() {
		return "before/about-us";
	}
	
	@RequestMapping("contact-us")
	public String contactUs() {
		return "before/contact-us";
	}
}
