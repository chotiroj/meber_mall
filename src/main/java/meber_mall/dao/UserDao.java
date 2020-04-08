package meber_mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import meber_mall.pojo.User;

@Mapper
public interface UserDao {
	@Select("select * from user_info where username=binary #{username} and password=binary #{password}")
	public List<User> userlogin(User user);
	
	@Select("select username from user_info where username=binary #{username}")
	public List<User>finduser(User user);
	
	@Insert("insert into user_info(id,username,password,phone_num,m_grade,user_jf) values(null,#{username},#{password},#{phone_num},0,0)")
	public int userregister(User user);
	
	
	
}
