package com.file.board.service.impl;

import org.springframework.web.multipart.MultipartFile;

import com.file.board.dao.PhotoBoardDAO;
import com.file.board.service.PhotoBoardService;
import com.file.board.vo.PhotoBoardVO;


public class PhotoBoardServiceImpl implements PhotoBoardService {
	private PhotoBoardDAO pbDAO;

	//BasicDataSource
	@Override
	public int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb) {
		System.out.println(file.getOriginalFilename());
		System.out.println(pb);
		return pbDAO.insertBoard(file, pb);
	}

}
