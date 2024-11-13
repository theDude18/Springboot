package com.karthi.springmvcorm.user.dao.services;

import java.util.List;

import com.karthi.springmvcorm.user.entity.User;

public interface UserService {
	int save(User user);
	List<User> showAll();
	User checkId(int id);
}
