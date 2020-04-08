package meber_mall.service;


import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import meber_mall.dao.UserDao;
import meber_mall.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	

	@Override
	public String userlogin(User user, HttpSession session) {
		// TODO 自动生成的方法存根
		User ruser=null;
		List<User>list=userDao.userlogin(user);
		if(list.size()>0) {
			ruser=list.get(0);
		}
		if(ruser!=null) {
			session.setAttribute("user", ruser);
			return "forward:index";
		}
		else {
			session.setAttribute("msg", "登录失败,用户名或密码错误!");
			return "before/login";

		}
	}


	@Override
	public String userregister(User user,HttpSession session) {
		int n=0;
		List<User>list=userDao.finduser(user);
		if(list.size()>0) {
			session.setAttribute("msg", "用户名不可用！");
			return "before/register";
		}
		else {
			n=userDao.userregister(user);
			if(n>0) {
				System.out.println("注册成功");
				List<User>list2=userDao.userlogin(user);
				if(list2.size()>0) {
					session.setAttribute("user", user);	
				}
			}
			return "forward:index";
		}
		
	}

}
