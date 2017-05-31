package com.rohith.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rohith.entities.UserEntity;
import com.rohith.modal.UserBean;
import com.rohith.repository.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDao;

	public List<UserBean> listUsers() {

		List<UserEntity> usersEntitiesList = userDao.listUsers();

		List<UserBean> userList = prepareModeList(usersEntitiesList);

		Collections.sort(userList);
		
		/*UserBean user1 = null;
		
		for (int i=0; i<userList.size(); i++) {
			
			UserBean user2 = null;
			if(i == 0) {
				user1 = userList.get(i);
			} else {
				user2 = userList.get(i);
			}
			
			user1.compareTo(user2);
			
			
		}*/
		
		
		return userList;

	}

	@Override
	public void insertUser(UserBean userBean) {

		UserEntity user = prepareModel(userBean);

		userDao.insertUser(user);

	}

	@Override
	public UserBean getUser(String username) {

		UserEntity userEntity = userDao.getUser(username);

		UserBean userBean = addUserBean(userEntity);

		return userBean;
	}

	private List<UserBean> prepareModeList(List<UserEntity> usersEntities) {

		List<UserBean> userList = new ArrayList<UserBean>();

		UserBean userBean = null;

		for (UserEntity userEntity : usersEntities) {

			userBean = new UserBean();

			userBean.setName(userEntity.getName());
			userBean.setEmail(userEntity.getEmail());
			userBean.setAddress(userEntity.getAddress());
			userBean.setPassword(userEntity.getPassword());
			userBean.setConfirmPassword(userEntity.getConfirmPassword());
			userBean.setSex(userEntity.getSex());
			userBean.setCountry(userEntity.getCountry());

			userList.add(userBean);

		}

		return userList;

	}

	private UserEntity prepareModel(UserBean userBean) {

		UserEntity userEntity = new UserEntity();

		userEntity.setName(userBean.getName());
		userEntity.setEmail(userBean.getEmail());
		userEntity.setAddress(userBean.getAddress());
		userEntity.setPassword(userBean.getPassword());
		userEntity.setConfirmPassword(userBean.getConfirmPassword());
		userEntity.setSex(userBean.getSex());
		userEntity.setCountry(userBean.getCountry());

		return userEntity;

	}

	private UserBean addUserBean(UserEntity userEntity) {

		UserBean userBean = new UserBean();
		if(userEntity != null) {
			userBean.setName(userEntity.getName());
			userBean.setEmail(userEntity.getEmail());
			userBean.setAddress(userEntity.getAddress());
			userBean.setPassword(userEntity.getPassword());
			userBean.setConfirmPassword(userEntity.getConfirmPassword());
			userBean.setSex(userEntity.getSex());
			userBean.setCountry(userEntity.getCountry());
		}

		return userBean;

	}

}
