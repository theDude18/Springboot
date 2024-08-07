package com.boot.springsecurity.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.springsecurity.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	public Users findByUsername(String username); //inbuilt method to fetch the row based on passed uname. Note: since we are checking with username, it should be unique.
}
