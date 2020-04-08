package meber_mall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import meber_mall.dao.CartDao;
import meber_mall.dao.OrderDao;
import meber_mall.pojo.Order;
import meber_mall.util.MyUtil;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CartDao cartDao;
	@Override
	public String addorder(HttpSession session,Double amount) {
		Order order=new Order();
		order.setAmount(amount);
		order.setUser_id(MyUtil.getUserId(session));
		//生成订单并返回主键id
		orderDao.addorder(order);
		//生成订单详情
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("user_id", MyUtil.getUserId(session));
		map.put("order_id", order.getId());	
		orderDao.orderdetail(map);
		
		//更新库存（1.查询购买数量，2.修改）
		List<Map<String, Object>>list=orderDao.selectshopnum(MyUtil.getUserId(session));
		if(list.size()>0) {
		for(Map<String, Object>map1:list) {
			orderDao.updatestore(map1);
		}
		}
		
		cartDao.clearCart(MyUtil.getUserId(session));
		System.out.println("订单提交成功");
		return "forward:touserCenter";
	}
	@Override
	public String selectorder(Model model,HttpSession session) {
		// TODO 自动生成的方法存根
		int totalnnum=0;
		List<Map<String, Object>>orderlist=orderDao.selectorder(MyUtil.getUserId(session));
		List<Map<String, Object>>footlist=orderDao.showfoot(MyUtil.getUserId(session));
		for(Map<String, Object>map:orderlist) {
			totalnnum+=(int)map.get("shopnum");
		}
		model.addAttribute("orderlist", orderlist);
		model.addAttribute("totalnum", totalnnum);
		model.addAttribute("footlist", footlist);
		return "before/userCenter";
	}
	@Override
	public int confirmorder(Integer id, Double user_jf,Integer goods_id) {
		int n=orderDao.confirmorder(id, user_jf);
		if(n>0) {
			if(orderDao.updatestatus(goods_id)>0) {
				System.out.println(user_jf);
				System.out.println("确认成功");
			}
			
			return 1;
		}
		else {
			System.out.println("确认失败");
			return 0;
		}
		
	}
	
	
}
