package com.bit2017.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2017.jblog.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;

	public UserVo getUser(UserVo vo) {
		UserVo user = sqlSession.selectOne("user.get", vo);
		return user;
	}

	public boolean joinUser(UserVo vo) {
		int count = sqlSession.insert("user.join", vo);
		return count == 1;
	}

	public UserVo loginUser(String id, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		return sqlSession.selectOne("user.getByIdAndPassword", map);
	}

	public UserVo get(String id){
		UserVo uservo=sqlSession.selectOne("user.getById",id);
		return uservo;
	}
}
