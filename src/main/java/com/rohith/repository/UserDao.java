package com.rohith.repository;

import java.util.List;

import com.rohith.entities.UserEntity;

public interface UserDao {

	public List<UserEntity> listUsers();
	
	public void insertUser(UserEntity user);
	
	public UserEntity getUser(String username);
}
