package meber_mall.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface CartService {
	public String putCart(Integer id,Integer shopnum,HttpSession session,Model model); 
	public String selectcart(Model model,HttpSession session,String act);
	public String clearCart(HttpSession session);
	public List<Map<String, Object>>addordecrease(Integer id,Integer user_id,String torf);
	public List<Map<String, Object>>chechorder(List<Integer> ids,Integer user_id);
	public String deleteAgoods(HttpSession session,Integer goods_id);
}
