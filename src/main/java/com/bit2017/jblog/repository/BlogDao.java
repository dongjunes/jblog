package com.bit2017.jblog.repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.bit2017.jblog.vo.BlogVo;

@Repository
public class BlogDao {
	private static final String URL = "jblog/";
	private static final String SAVE_PATH = "/uploads";

	@Autowired
	private SqlSession sqlSession;

	public BlogVo get(String id) {
		BlogVo vo = sqlSession.selectOne("blog.get", id);
		return vo;
	}

	public boolean join(String id){
		int count=sqlSession.insert("blog.upload",id);
		return count==1;
	}
	
	public boolean upload(String id, String title, MultipartFile file) {
		System.out.println("blog dao : " + id + "," + title);
		String url = "";
		try {
			if (file.isEmpty() == true) {
				System.out.println("blog dao : 실패");
				return false;
			}

			String originalFileName = file.getOriginalFilename();
			String extName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1,
					originalFileName.length());
			String saveFileName = generateSaveFileName(extName);
			url = URL + saveFileName;
			writeFile(file, saveFileName);
		} catch (IOException e) {
			new RuntimeException("upload file:" + e.getMessage());
		}
		BlogVo vo = new BlogVo();
		vo.setId(id);
		vo.setTitle(title);
		vo.setSaveFile(url);
		int count = sqlSession.update("blog.upload", vo);
		return count == 1;

	}

	private void writeFile(MultipartFile file, String saveFileName) throws IOException {

		byte[] data = file.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(data);
		fos.close();

	}

	private String generateSaveFileName(String extName) {
		String fileName = "";

		Calendar calendar = Calendar.getInstance();

		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += ("." + extName);

		return fileName;
	}

}
