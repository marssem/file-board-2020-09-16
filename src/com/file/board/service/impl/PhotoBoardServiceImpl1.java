package com.file.board.service.impl;

import org.springframework.web.multipart.MultipartFile;

import com.file.board.service.PhotoBoardService;
import com.file.board.vo.PhotoBoardVO;

public class PhotoBoardServiceImpl1 implements PhotoBoardService {

	@Override
	public int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb) {
		System.out.println(file.getOriginalFilename());
		System.out.println(pb);
		return 0;
	}

}
