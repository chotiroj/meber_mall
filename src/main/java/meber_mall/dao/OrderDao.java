package meber_mall.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import meber_mall.pojo.Order;

@Mapper
public interface OrderDao {
	@Insert("insert into order_info(user_id,orderdate,amount)values(#{user_id},now(),#{amount})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	public int addorder(Order order);
	
	@Insert("insert into orderdetail_info(id,order_id,goods_id,shopnum,status) select null,#{order_id},goods_id,shopnum,0 from cart_info where user_id=#{user_id}")
	public int orderdetail(Map<String,Object>map);
	
	@Select("select shopnum,goods_id from cart_info where user_id=#{user_id}")
	public List<Map<String, Object>>selectshopnum(Integer user_id);
	
	@Update("update goods_info set gsstore=gsstore-#{shopnum} where id=#{goods_id}")
	public int updatestore(Map<String, Object>map);
	
	@Select("select a.id,a.gsname,a.gsrprice,a.gsactive,a.gspicture,a.gsrprice*b.shopnum as smallcount,b.shopnum,b.order_id,b.status,c.amount from goods_info a left join orderdetail_info b on a.id=b.goods_id left join order_info c on b.order_id=c.id where c.user_id=#{id}")
	public List<Map<String, Object>>selectorder(Integer id);
	
	@Select("select gsin.id,gsin.gsname,gsin.gspicture,gsin.gsrprice,gsin.gsprice from goods_info gsin,foot_print ftin where gsin.id=ftin.goods_id and ftin.user_id=#{user_id} order by ftin.time desc limit 8")
	public List<Map<String, Object>>showfoot(Integer user_id);
	
	@Update("update user_info set user_jf=user_jf+#{user_jf} where id=#{id}")
	public int confirmorder(@Param("id")Integer id,@Param("user_jf")Double user_jf);
	
	@Update("update orderdetail_info set status=1 where goods_id=#{goods_id}")
	public int updatestatus(@Param("goods_id")Integer goods_id);
	
}
