package meber_mall.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;



import meber_mall.util.ToArray;
import net.sf.json.JSONArray;

@RestController
public class OrderController1 {
	
	public List selectgoods(@RequestBody Integer[] goods_ids,Integer user_id){
		List<Map<String, Object>>list1=null;
		JSONArray jsonArray=JSONArray.fromObject(goods_ids); 
		Object[]objects=ToArray.toArray(jsonArray);
		System.out.println("============="+Arrays.toString(objects));
		System.out.println(goods_ids);
		System.out.println(user_id);
		return null;
	}
}
