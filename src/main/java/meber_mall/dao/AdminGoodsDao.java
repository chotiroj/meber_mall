package meber_mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import meber_mall.pojo.Goods;

@Mapper
public interface AdminGoodsDao {
	@Insert("insert into goods_info (id,gsname,gsprice,gsstore,gsrprice,gsactive,activedetail,gspicture,goodstype_id)values(null,#{gsname},#{gsprice},#{gsstore},#{gsrprice},#{gsactive},#{activedetail},#{gspicture},#{goodstype_id})")
	public int addGoods(Goods goods);
	
	@Select("select * from goods_info where gsname like concat('%',#{gsname},'%')")
	public List<Goods>selectgoodsbyname(String gsname);
	
	@Delete("delete from goods_info where id=#{id}")
	public int deleteAgoods(Integer id);
	
	@Update({"<script>","update goods_info", "<set>","<if test='gsname!=null'>gsname=#{gsname},</if>","<if test='gsrprice!=null'>gsrprice=#{gsrprice},</if>","<if test='gsprice!=null'>gsprice=#{gsprice},</if>","<if test='gsstore!=null'>gsstore=#{gsstore},</if>","<if test='gsactive!=null'>gsactive=#{gsactive},</if>","<if test='activedetail!=null'>activedetail=#{activedetail},</if>","<if test='gspicture!=null'>gspicture=#{gspicture},</if>","<if test='goodstype_id!=null'>goodstype_id=#{goodstype_id},</if>","</set>","where id=#{id}","</script>"})
	public int updateAgoods(Goods goods);
	
	@Select("select * from goods_info")
	public List<Goods>selectgoods();
	
	@Select("select * from goods_info where id=#{id}")
	public List<Goods>updateselectAgoods(Integer id);
}
