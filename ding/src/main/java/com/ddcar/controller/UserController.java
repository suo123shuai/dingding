package com.ddcar.controller;

import com.common.BaseBean;
import com.common.Commonparam;
import com.common.MD5Util;
import com.ddcar.entity.TbManager;
import com.ddcar.service.TbManagerService;
import com.ddcar.service.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class UserController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserManager userManager;
	@Autowired
	TbManagerService tbManagerService;

	@RequestMapping(value = "/api/user/loginManager")
	public @ResponseBody BaseBean loginManager(
			@RequestParam("account") String account,
			@RequestParam("password") String password,
			HttpServletRequest request) throws Exception {
		BaseBean bean = new BaseBean();
		try {
			HashMap param = new HashMap();
			param.put("account", account);
			param.put("password", MD5Util.digest(password));
			TbManager manager=userManager.loginManager(param);
			if (manager == null) {
				bean.setStatus(400);
				bean.setMsg("账号或密码错误！");
			} else {
				if(manager.getuStatus()==2){
					bean.setStatus(400);
					bean.setMsg("账号未激活！");
				}else{
					bean.setStatus(200);
					request.getSession().setAttribute(Commonparam.USER_MANAGER_SESSION, manager);
				}
				
			}
			logger.error("测试 error 日志 ---------");
		} catch (Exception e) {
			bean.setMsg(Commonparam.handle(e));
		}
		return bean;
	}	
	/*@RequestMapping(value = "/api/user/findUserList")
	public @ResponseBody BaseBean findCrusieCompanyList(Integer page,Integer size) throws Exception {
		BaseBean bean = new BaseBean();
		try {
			List<User> list=userManager.findUserList(page,size);
			bean.setStatus(200);
			bean.setRows(list);
			bean.setTotal(new PageInfo<>(list).getTotal());

		} catch (Exception e) {
			bean.setMsg(Commonparam.handle(e));
		}
		return bean;
	}*/

//	public @ResponseBody BaseBean loginUser(@RequestParam("account") String account,
//										 @RequestParam("password") String password,
//										 HttpServletRequest request){
//	BaseBean bean = new BaseBean();
//	try {
//		Map map = new HashMap();
//		map.put("account", account);
//		map.put("password", MD5Util.digest(password));
//		TbUser manager = user.loginUser(map);
//		if (manager == null) {
//			bean.setStatus(400);
//			bean.setMsg("账号或密码错误！");
//		} else {
//			if(manager.getState().equals(1)){
//				bean.setStatus(400);
//				bean.setMsg("账号未激活！");
//			}else{
//				bean.setStatus(200);
//				request.getSession().setAttribute(Commonparam.USER_MANAGER_SESSION, manager);
//			}
//		}
//
//	} catch (Exception e) {
//		bean.setMsg(Commonparam.handle(e));
//	}
//	return bean;
//}


}
