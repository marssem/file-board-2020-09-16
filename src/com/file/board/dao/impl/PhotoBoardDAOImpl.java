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
		try(SqlSession ss = ms.openSession()){
			return ss.insert("user.insertFile", pb);
		}
	}


	@Override
	public List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb) {
		try(SqlSession ss = ms.openSession()){
			return ss.selectList("user.selectPhotoBoardList", pb);
		}
	}


	@Override
	public int selectPhotoBoardCount(PhotoBoardVO pb) {
		try(SqlSession ss = ms.openSession()){
			return ss.selectOne("user.selectPhotoBoardCount", pb);
		}
	}


	

	@Override
	public List<PhotoBoardVO>  selectPhotoBoardsForDelete(int[] pbNums) {
		try(SqlSession ss = ms.openSession()){
			System.out.println("dao for delete");
			return ss.selectList("user.selectPhotoBoardforDelete",pbNums);
		}
		
	}


	@Override
	public int deletePhotoBoards(int[] pbNums) {
		try(SqlSession ss = ms.openSession()){
			int cnt = 0;
			System.out.println("dao !!");
			for(int pbNum:pbNums) {
				cnt += ss.delete("user.deletePhotoBoard",pbNum);
			}
			return cnt;
		}
	}


	@Override
	public int updatePhotoBoard(MultipartFile file, PhotoBoardVO pb) {
		try(SqlSession ss = ms.openSession()){
			return ss.update("user.insertFile", pb);
		}
	}

}
