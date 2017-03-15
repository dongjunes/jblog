package com.bit2017.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2017.jblog.repository.CategoryDao;
import com.bit2017.jblog.vo.CategoryVo;


@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public List<CategoryVo> getMessage() {
		return categoryDao.get();
	}
	public boolean add(CategoryVo categoryVo) {
		return categoryDao.add(categoryVo);
	}
	
	public boolean remove(Long no){
		return categoryDao.remove(no);
	}
}
