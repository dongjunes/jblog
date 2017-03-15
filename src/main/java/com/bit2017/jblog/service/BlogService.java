package com.bit2017.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2017.jblog.repository.BlogDao;
import com.bit2017.jblog.repository.WriteDao;
import com.bit2017.jblog.vo.BlogVo;
import com.bit2017.jblog.vo.WriteVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;

	@Autowired
	private WriteDao writeDao;
	
	public boolean upload(String id,String title,MultipartFile logo) {
		return blogDao.upload(id,title,logo);
	}
	
	public BlogVo get(String id){
		return blogDao.get(id);
	}
	
	public List<WriteVo> getList(Long categoryNo){
		return writeDao.getList(categoryNo);
	}

	public WriteVo getVo(Long categoryNo) {
		return writeDao.getView(categoryNo);
	}
	public WriteVo getVo(Long categoryNo,Long no) {
		return writeDao.getViewByNo(categoryNo,no);
	}
}
