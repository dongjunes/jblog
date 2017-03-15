package com.bit2017.jblog.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2017.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {
	@Autowired
	private SqlSession sqlSession;

	public boolean join(String id) {
		int count = sqlSession.insert("blog.join", id);
		return count == 1;
	}
	
	public List<CategoryVo> get(){
		List<CategoryVo> list=new ArrayList<CategoryVo>();
		list=sqlSession.selectList("getList");
		return list;
	}
	
	public boolean add(CategoryVo categoryVo) {
		int count = sqlSession.insert("category.insert", categoryVo);
		return count == 1;
	}
	
	public boolean remove(Long no){
		int count=sqlSession.delete("category.removeByNo",no);
		return count==1;
	}
	
	public Long getLong(String title){
		return sqlSession.selectOne("category.getByTitle",title);
		
	}
	
}
