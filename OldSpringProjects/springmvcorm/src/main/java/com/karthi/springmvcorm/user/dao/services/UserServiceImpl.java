package com.karthi.springmvcorm.user.dao.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karthi.springmvcorm.user.dao.UserDao;
import com.karthi.springmvcorm.user.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
		@Autowired
		UserDao dao;

		public UserDao getDao() {
			return dao;
		}

		public void setDao(UserDao dao) {
			this.dao = dao;
		}

		@Override
		@Transactional
		public int save(User user) {
			//Business Logic
			return dao.create(user);
		}
		
		public List<User> showAll(){
			//Business logic
			return dao.displayAll();
		}
		
		public User checkId(int id) {
			return dao.checkId(id);
		}
		
		
}
