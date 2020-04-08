package meber_mall.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface CartDao {
	@Select("select * from cart_info where user_id=#{user_id} and goods_id=#{goods_id}")
	public List<Map<String, Object>>isPutCart(Map<String, Object>map);
	
	@Insert("insert into cart_info(id,user_id,goods_id,shopnum,checked)values(null,#{user_id},#{goods_id},#{shopnum},1)")
	public int putCart(Map<String, Object>map);
	
	@Update("update cart_info set shopnum=shopnum+#{shopnum} where user_id=#{user_id} and goods_id=#{goods_id}")
	public int updateCart(Map<String, Object>map);
	
	@Select("select gsin.id,gsin.gsname,gsin.gsprice,gsin.gsrprice,gsin.gspicture,ctin.shopnum,ctin.shopnum*gsin.gsrprice as smallcount from goods_info gsin,cart_info ctin where gsin.id=ctin.goods_id and user_id=#{user_id}")
	public List<Map<String,Object>>selectCart(Integer user_id);
	
	@Delete("delete from cart_info where user_id=#{user_id}")
	public int clearCart(Integer user_id);
	
	@Update("update cart_info set shopnum=shopnum-1 where user_id=#{user_id} and goods_id=#{goods_id}")
	public int decrease(Map<String, Object>map);
	
	@Update("update cart_info set shopnum=shopnum+1 where user_id=#{user_id} and goods_id=#{goods_id}")
	public int addone(Map<String, Object>map);
	//update语句不能返回List类型数据
	
	@Select({"<script>","select gsin.*,ctin.shopnum from goods_info gsin,cart_info ctin","where ctin.user_id=#{user_id} and gsin.id=ctin.goods_id and goods_id in","<foreach item='id' collection='ids' open='(' separator=',' close=')'>","#{id}","</foreach>","</script>"})
	public List<Map<String,Object>>checkedorder(@Param("ids")List<Integer>ids,@Param("user_id")Integer user_id);
	
	@Delete("delete from cart_info where goods_id=#{goods_id} and user_id=#{user_id}")
	public int deleteAgoods(Map<String, Object>map);
}
