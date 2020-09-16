package com.file.board.dao;

import org.springframework.web.multipart.MultipartFile;

import com.file.board.vo.PhotoBoardVO;

public interface PhotoBoardDAO {
	public int insertBoard(MultipartFile file, PhotoBoardVO pb);
}
