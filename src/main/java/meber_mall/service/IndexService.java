package meber_mall.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import meber_mall.pojo.Goods;

public interface IndexService {
	public String index(Model model,Goods goods,HttpSession session);
	public String goodsdetail(HttpSession session,Integer id,Model model);
	public String search(String gsname,Model model);
}
