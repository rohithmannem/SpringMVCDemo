package com.rohith.service;

import java.util.List;

import com.rohith.entities.UserEntity;
import com.rohith.modal.UserBean;

public interface UserService {


  public List<UserBean> listUsers();
	
  public void insertUser(UserBean userBean);
  
  public UserBean getUser(String username);
  
  
}
