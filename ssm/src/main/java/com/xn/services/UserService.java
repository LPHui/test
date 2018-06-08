package com.xn.services;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.xn.entity.User;

public interface UserService {
    public int addUser(User user);
    public int delUserById(Integer id);
    public List<User> getUser(Map<String,Object> map);
    public int updateUser(User user);
	User findBylogin(User user);
	
	User findByName(String name);
}
