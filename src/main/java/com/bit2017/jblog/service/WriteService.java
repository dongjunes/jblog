package com.bit2017.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2017.jblog.repository.CategoryDao;
import com.bit2017.jblog.repository.WriteDao;
import com.bit2017.jblog.vo.WriteVo;

@Service
public class WriteService {

	@Autowired
	private WriteDao writeDao;
	@Autowired
	private CategoryDao categoryDao;

	public boolean add(WriteVo vo) {
		vo.setCategoryNo(categoryDao.getLong(vo.getCategory()));
		System.out.println("writeService : " + vo.getCategoryNo());
		return writeDao.add(vo);
	}

}
