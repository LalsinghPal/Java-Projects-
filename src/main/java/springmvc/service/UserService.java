package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.UserDao;
import springmvc.model.User;

@Service
public class UserService {
	
	@Autowired(required=true)
	private UserDao userDao;
	
	public int createUser(User user) {
		return userDao.saveUser(user);
		
		
	}

}
