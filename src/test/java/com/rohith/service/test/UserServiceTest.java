package com.rohith.service.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.rohith.modal.UserBean;
import com.rohith.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:**/configuration/springDemo-context-test.xml"})
public class UserServiceTest {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	//@Test
	public void listUsersTest() {
			
		List<UserBean> userList = userService.listUsers();
		System.out.println("Size of Users --- " + userList.size());
	
	}
	
}
