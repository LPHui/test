package com.xn.dao;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.xn.entity.User;

public interface UserDao {
    public int addUser(User user);
    public int delUserById(Integer id);
    public List<User> getUser(Map<String,Object> map);
    public int updateUser(User user);
    
	User findByUser(User user);
	
	User findByName(String name);

}
