package com.xn.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xn.dao.UserDao;
import com.xn.entity.User;
import com.xn.services.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDao userDao;


	public int addUser(User user) {
		 return userDao.addUser(user);
	}

	public int delUserById(Integer id) {
		 return userDao.delUserById(id);
	}

	public List<User> getUser(Map<String, Object> map) {
		 return userDao.getUser(map);
	}

	public int updateUser(User user) {
		 return userDao.updateUser(user);
	}

	public User findBylogin(User user) {
		return userDao.findByUser(user);
	}

	public User findByName(String name) {
		return userDao.findByName(name);
	}

}
