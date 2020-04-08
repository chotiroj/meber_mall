package meber_mall.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import meber_mall.dao.AdminGoosTypeDao;
import meber_mall.dao.CartDao;
import meber_mall.dao.IndexDao;
import meber_mall.pojo.Goods;
import meber_mall.util.MyUtil;

@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
	private IndexDao indexDao;
	@Autowired
	private AdminGoosTypeDao adminGoosTypeDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Override
	public String index(Model model,Goods goods,HttpSession session) {
		// TODO 自动生成的方法存根
		model.addAttribute("goodstype",adminGoosTypeDao.selectType());
		model.addAttribute("goodslist",indexDao.getGoods(goods));
		model.addAttribute("sale", indexDao.hotSale());
		List<Map<String, Object>>list=cartDao.selectCart(MyUtil.getUserId(session));
		if(goods.getId()==null) {
			goods.setId(0);
			model.addAttribute("cartlist", list);
			model.addAttribute("goodslist",indexDao.getGoods(goods));
			return "before/index";
		}
		else if(goods.getId()>0) {
			return "before/product-grid";
		}
		return "before/index";
	}

	@Override
	public String goodsdetail(HttpSession session,Integer id, Model model) {
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("user_id", MyUtil.getUserId(session));
		map.put("goods_id", id);
		List<Goods>goods=indexDao.goodsdetail(id);
		model.addAttribute("goods", goods);
		if(MyUtil.getUserId(session)==null) {
			return "before/product-details";
		}
		else{
			List<Map<String, Object>>foot=indexDao.isfoot(map);
			if(foot.size()>0) {
				return "before/product-details";
			}
			else {
				indexDao.footprint(map);
			}
			return "before/product-details";
			
		}
	}

	@Override
	public String search(String gsname, Model model) {
		List<Goods>search_result=indexDao.searchlike(gsname);
		if(search_result.size()>0) {
			model.addAttribute("searchlist",search_result);
		}
		return "before/product-list";
	}
	
	
	
	
}
