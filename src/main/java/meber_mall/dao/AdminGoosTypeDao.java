package meber_mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import meber_mall.pojo.GoodsType;

@Mapper
public interface AdminGoosTypeDao {
	@Select("select * from type_info")
	public List<GoodsType>selectType();
	
	@Select("select * from type_info where typename like concat('%',#{typename},'%')")
	public List<GoodsType>selectlike(String typename);
	
	@Insert("insert into type_info(id,typename)values(null,#{typename})")
	public int addType(String typename);
	
	@Delete("delete from type_info where id=#{id}")
	public int deleteType(Integer id);
}