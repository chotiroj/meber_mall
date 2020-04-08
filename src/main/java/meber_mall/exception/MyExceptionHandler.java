package meber_mall.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import meber_mall.pojo.User;

//springmvc的登录异常拦截
@Component
public class MyExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,Exception arg3) {
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("ex", arg3);
		 if(arg3 instanceof UserLoginNoException) {
			arg0.setAttribute("user",new User());
			arg0.setAttribute("msg", "您还未登录，请进行登录！");
			return new ModelAndView("/before/login",model);
		}
		else {
			return new ModelAndView("",model);
		}
		
	}
}
