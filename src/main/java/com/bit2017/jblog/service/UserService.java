package com.bit2017.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2017.jblog.repository.BlogDao;
import com.bit2017.jblog.repository.CategoryDao;
import com.bit2017.jblog.repository.UserDao;
import com.bit2017.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CategoryDao categoryDao;

	public UserVo getUser(UserVo vo) {
		UserVo user = userDao.getUser(vo);
		categoryDao.join(vo.getId());
		return user;
	}

	public boolean joinUser(UserVo vo) {
		userDao.joinUser(vo);
		blogDao.join(vo.getId());
		return categoryDao.join(vo.getId());
	}

	public UserVo login(String id, String password) {
		return userDao.loginUser(id, password);
	}

	public boolean exists(String id) {
		System.out.println("exists id : "+id);
		UserVo userVo = userDao.get(id);
		System.out.println("userDao : "+userVo);
		return (userVo != null);
	}

}
