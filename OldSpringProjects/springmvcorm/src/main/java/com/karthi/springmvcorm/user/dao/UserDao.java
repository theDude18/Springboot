package com.karthi.springmvcorm.user.dao;

import java.util.List;

import com.karthi.springmvcorm.user.entity.User;

public interface UserDao {
		int create(User user);
		List<User> displayAll();
		User checkId(int id);
}
