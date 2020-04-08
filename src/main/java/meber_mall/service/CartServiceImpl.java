package meber_mall.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import meber_mall.dao.CartDao;
import meber_mall.util.MyUtil;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;
	
	@Override
	public String putCart(Integer id, Integer shopnum,HttpSession session,Model model) {
		Map<String, Object>map=new HashMap<>();
		map.put("user_id", MyUtil.getUserId(session));
		map.put("goods_id", id);
		map.put("shopnum", shopnum);
		map.put("checked", 1);
		List<Map<String, Object>>list=cartDao.isPutCart(map);
		if(list.size()>0) {
			cartDao.updateCart(map);
			System.out.println("修改成功");
		}
		else {
			cartDao.putCart(map);
			System.out.println("添加成功");
		}
		model.addAttribute("msg", "加入购物车成功！");
		return "forward:goodsdetail";
	}

	@Override
	public String selectcart(Model model,HttpSession session,String act) {
		List<Map<String, Object>>cartlist=cartDao.selectCart(MyUtil.getUserId(session));
		System.out.println("查询成功");
		double sum=0;
		for(Map<String, Object>map:cartlist) {
			sum+=(Double)map.get("smallcount");
		}
		model.addAttribute("cartlist", cartlist);
		model.addAttribute("amount", sum);
			return "before/index::shopcart";			//shopcart为th:fragment的名称；
	}

	@Override
	public List<Map<String, Object>> addordecrease(Integer id, Integer user_id, String torf) {
		int update;
		List<Map<String, Object>>cartlist;
		Map<String, Object>map=new HashMap<>();
		map.put("user_id", user_id);
		map.put("goods_id", id);
		List<Map<String, Object>>list=cartDao.isPutCart(map);
		if("0".equals(torf)&&list.size()>0) {
			update=cartDao.decrease(map);
			if(update>0) {
				cartlist=cartDao.selectCart(user_id);
				System.out.println("修改成功");
				return cartlist;
			}
			
		}
		else {
			update=cartDao.addone(map);
			if(update>0) {
				cartlist=cartDao.selectCart(user_id);
				System.out.println("修改成功");
				return cartlist;
			}
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> chechorder(List<Integer> ids,Integer user_id) {
		// TODO 自动生成的方法存根
	
		System.out.println(ids);
		List<Map<String, Object>>cartlist=cartDao.checkedorder(ids,user_id);
		return cartlist;
	}

	@Override
	public String deleteAgoods(HttpSession session,Integer goods_id) {
		Map<String, Object>map=new HashMap<>();
		map.put("user_id", MyUtil.getUserId(session));
		map.put("goods_id", goods_id);
		int n=cartDao.deleteAgoods(map);
		if(n>0) {
			return "forward:index";
		}
		return "";
	}

	@Override
	public String clearCart(HttpSession session) {
		int n=cartDao.clearCart(MyUtil.getUserId(session));
		if (n>0) {
			return "forward:index";
		}
		return null;
	}
	
}
