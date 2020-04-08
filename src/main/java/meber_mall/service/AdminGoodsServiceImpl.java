 package meber_mall.service;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import meber_mall.dao.AdminGoodsDao;
import meber_mall.dao.AdminGoosTypeDao;
import meber_mall.pojo.Goods;
import meber_mall.pojo.GoodsType;
import meber_mall.util.MyUtil;

@Service
public class AdminGoodsServiceImpl implements AdminGoodsService{
	@Autowired
	private AdminGoodsDao adminGoodsDao;
	
	@Autowired
	private AdminGoosTypeDao adminGoosTypeDao;
	
	@Override
	public String addGoods(Goods goods,HttpServletRequest request) {
		String newFileName="";
		String fileName=goods.getLogoImage().getOriginalFilename();
		if(fileName.length()>0) {
			 String realpath=request.getServletContext().getRealPath("images");
			 String fileType=fileName.substring(fileName.lastIndexOf('.'));
			 newFileName=MyUtil.getStringID()+fileType;
			 goods.setGspicture(newFileName);
			 File targetFile=new File(realpath,newFileName);
			 if(!targetFile.exists()) {
				 targetFile.mkdirs();
			 }
			
			 try {
				 goods.getLogoImage().transferTo(targetFile);
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
		}
		if (adminGoodsDao.addGoods(goods)>0) {
			System.out.println("添加成功");
			return "forward:main";
		}
		
		return null;
	}

	@Override
	public String seleteGoods(String key,Model model) {
		List<Goods>list=adminGoodsDao.selectgoodsbyname(key);
		model.addAttribute("list",list);
		System.out.println("查询成功");
		return "main";
	}

	@Override
	public String seleteallgoods(Model model) {
		// TODO 自动生成的方法存根
		List<Goods>list=adminGoodsDao.selectgoods();
		model.addAttribute("list", list);
		return "main";
	}

	@Override
	public String deleteAgoods(Integer id) {
		adminGoodsDao.deleteAgoods(id);
	System.out.println("删除成功");
		return "forward:main";
	}

	@Override
	public String selectAgoods(Integer id,Model model) {
		List<Goods>list=adminGoodsDao.updateselectAgoods(id);
		List<GoodsType>list2=adminGoosTypeDao.selectType();
		model.addAttribute("list2", list2);
		model.addAttribute("list", list);
		return "updateselectAGoods";
	}

	@Override
	public String updateAgoods(Goods goods,HttpServletRequest request) {
		String newFileName="";
		String fileName=goods.getLogoImage().getOriginalFilename();
		if(fileName.length()>0) {
			 String realpath=request.getServletContext().getRealPath("images");
			 String fileType=fileName.substring(fileName.lastIndexOf('.'));
			 newFileName=MyUtil.getStringID()+fileType;
			 goods.setGspicture(newFileName);
			 File targetFile=new File(realpath,newFileName);
			 if(!targetFile.exists()) {
				 targetFile.mkdirs();
			 }
			
			 try {
				 goods.getLogoImage().transferTo(targetFile);
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
		}
		if (adminGoodsDao.updateAgoods(goods)>0) {
			System.out.println("修改成功");
			System.out.print(goods.getGsname());
			return "forward:main";
		}
		return null;
	}

	@Override
	public String selectType(Model model) {
		List<GoodsType>typelist=adminGoosTypeDao.selectType();
		model.addAttribute("typelist", typelist);
		return "selectType";
	}

	@Override
	public String selectlike(Model model, String key) {
		List<GoodsType>likelist=adminGoosTypeDao.selectlike(key);
		model.addAttribute("typelist", likelist);
		return "selectType";
	}

	@Override
	public String addType(String typename) {
		// TODO 自动生成的方法存根
		if(adminGoosTypeDao.addType(typename)>0) {
			System.out.println("添加类型成功");
		}
		return "forward:selectType";
	}

	@Override
	public String deleteType(Integer id) {
		if(adminGoosTypeDao.deleteType(id)>0)
		{
			System.out.println("删除类型成功");
		}
		return "forward:selectType";
	}

}
