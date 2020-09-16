package com.file.board.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.controller.PhotoBoardController;
import com.file.board.dao.PhotoBoardDAO;
import com.file.board.vo.PhotoBoardVO;


@Repository
public class PhotoBoardDAOImpl implements PhotoBoardDAO {
	 private PhotoBoardController pbController;
	 private static SqlSessionFactory ssf;
	 
	 static {
		
	 }
	 
	
	public int insertBoard(MultipartFile file, PhotoBoardVO pb) {
		
		
		return 0;
	}
}
