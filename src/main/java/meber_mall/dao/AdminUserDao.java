package meber_mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import meber_mall.pojo.User;

@Mapper
public interface AdminUserDao {
	@Select("select * from user_info")
	public List<User>userlist();
}
