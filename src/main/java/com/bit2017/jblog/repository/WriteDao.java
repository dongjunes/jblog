package com.bit2017.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2017.jblog.vo.WriteVo;

@Repository
public class WriteDao {

	@Autowired
	private SqlSession sqlSession;

	public boolean add(WriteVo vo) {
		System.out.println("write dao vo : " + vo);
		int count = sqlSession.insert("write.add", vo);
		return count == 1;
	}

	public List<WriteVo> getList(Long categoryNo) {
		return sqlSession.selectList("write.getByNo", categoryNo);
	}

	public WriteVo getView(Long categoryNo){
		return sqlSession.selectOne("write.getview",categoryNo);
	}

	public WriteVo getViewByNo(Long categoryNo, Long no) {
		WriteVo vo=new WriteVo();
		vo.setNo(no);
		vo.setCategoryNo(categoryNo);
		return sqlSession.selectOne("write.getviewByNo",vo);
	}
	
}
