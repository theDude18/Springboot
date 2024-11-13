package com.karthi.springmvcorm.user.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.karthi.springmvcorm.user.dao.UserDao;
import com.karthi.springmvcorm.user.entity.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}


	public int create(User user) {
		int result=(Integer)ht.save(user);
		return result;
	}
	
	public List<User> displayAll(){
		return ht.loadAll(User.class);
	}
	
	public User checkId(int id) {
		return ht.get(User.class, id);
	}
}




