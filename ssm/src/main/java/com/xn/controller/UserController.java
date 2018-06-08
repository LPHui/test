package com.xn.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.xn.entity.User;
import com.xn.services.UserService;
import com.xn.utils.ResponseUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/login")
	public void login(User user,HttpServletResponse response) {
		User user1 = userService.findBylogin(user);
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			if(user1==null){
				ResponseUtil.write(response,"�û�������");
			}

			map.put("name", user1.getUsername());
			map.put("pwd", user1.getPassword());
			map.put("reTime", user1.getRegTime());
			ResponseUtil.write(response,map);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@RequestMapping(value="/add")
	public void add(User user, HttpServletResponse response) throws Exception {
		user.setStatus(0);
		user.setRegTime(new Date());
		user.setRegip("127.0.0.1");
		int flag = userService.addUser(user);
		if(flag<=0){
			ResponseUtil.write(response,"����ʧ�ܣ�");
		}else{
			ResponseUtil.write(response,"�����ɹ���");
		}
	}


	@RequestMapping("/del")
	public void del(Integer id,HttpServletResponse response) throws Exception {
		int flag = userService.delUserById(id);
		if(flag<=0){
			ResponseUtil.write(response,"ʧ�ܣ�");
		}else{
			ResponseUtil.write(response,"�ɹ���");
		}
	}

	@RequestMapping("/get")
	public void getUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");

		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id",id);
		map.put("name",name);
		map.put("age",age);
		List<User> list =  userService.getUser(map);
		if(list==null || list.size()==0){
			ResponseUtil.write(response,"û������");
			return;
		}
		ResponseUtil.write(response,list);
	}

	@RequestMapping("/update")
	public void update(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		if(StringUtils.isEmpty(id)){
			ResponseUtil.write(response,"��������Ϊ��!");
			return;
		}
		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setUsername(name);
		if(StringUtils.isEmpty(age)){
			//user.setAge(null);
		}else{
			//user.setAge(Integer.valueOf(age));
		}
		int flag = userService.updateUser(user);
		if(flag<=0){
			ResponseUtil.write(response,"ʧ�ܣ�");
		}else{
			ResponseUtil.write(response,"�ɹ���");
		}
	}
}
