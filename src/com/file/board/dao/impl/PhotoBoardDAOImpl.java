package com.file.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.controller.MybatisServlet;
import com.file.board.dao.PhotoBoardDAO;
import com.file.board.vo.PhotoBoardVO;


@Repository("photoBoardDAO")
public class PhotoBoardDAOImpl implements PhotoBoardDAO {
	@Autowired
	 private SqlSessionFactory ms;
	
	@Override
	public int insertBoard(MultipartFile file, PhotoBoardVO pb) {
		System.out.println("dao!!");
		try(SqlSession ss = ms.openSession()){
			
			return ss.insert("user.insertFile", pb);
		}
	}


	@Override
	public List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb) {
		try(SqlSession ss = ms.openSession()){
			System.out.println("dao list!!");
			return ss.selectList("user.selectPhotoBoardList", pb);
		}
	}


	@Override
	public int selectPhotoBoardCount(PhotoBoardVO pb) {
		try(SqlSession ss = ms.openSession()){
			System.out.println("dao count!!");
			return ss.selectOne("user.selectPhotoBoardCount", pb);
		}
	}

}
