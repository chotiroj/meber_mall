package meber_mall.service;



import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import meber_mall.pojo.Goods;

public interface AdminGoodsService {
	public String addGoods(Goods goods,HttpServletRequest request);
	public String seleteGoods(String key,Model model);
	public String seleteallgoods(Model model);
	public String deleteAgoods(Integer id);
	public String selectAgoods(Integer id,Model model);
	public String updateAgoods(Goods goods,HttpServletRequest request);
	public String selectType(Model model);
	public String selectlike(Model model,String key);
	public String addType(String typename);
	public String deleteType(Integer id);
}
