package meber_mall.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import meber_mall.pojo.Goods;
@Mapper
public interface IndexDao {       
	
	@Select({"<script>",
		"select gs.gsname,gs.gsactive,gs.gspicture,gs.gsprice,gs.gsrprice,gs.id from goods_info gs,type_info tpin", 
		"where gs.goodstype_id=tpin.id",
		"<if test='id!=0'>",
		"and tpin.id=#{id}",
		"</if>",
		"order by gs.id asc limit 15",
		"</script>"})
	public List<Map<String,Object>>getGoods(Goods goods);
	
	@Select("select * from goods_info where id=#{id}")
	public List<Goods>goodsdetail(Integer id);
	
	@Select("select * from goods_info where gsname like concat('%',#{gsname},'%')")
	public List<Goods>searchlike(String gsname);
	
	@Select("select sum(odin.shopnum) as shopnumber,gsin.id,gsin.gsname,gsin.gsrprice,gsin.gsprice,gsin.gspicture from goods_info gsin left join orderdetail_info odin on odin.goods_id=gsin.id group by gsin.id,gsin.gsname,gsin.gsrprice,gsin.gsprice,gsin.gspicture order by shopnumber desc limit 10")//需要分组
	public List<Goods>hotSale();
	
	
	@Insert("insert into foot_print(id,user_id,goods_id,time)values(null,#{user_id},#{goods_id},now())")
	public int footprint(Map<String, Object>map);
	
	@Select("select * from foot_print where user_id=#{user_id} and goods_id=#{goods_id}")
	public List<Map<String, Object>>isfoot(Map<String, Object>map);
	
}

