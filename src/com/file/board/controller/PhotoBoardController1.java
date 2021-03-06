package com.file.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.service.PhotoBoardService;
import com.file.board.vo.PhotoBoardVO;

@Controller
public class PhotoBoardController1 {
	@Autowired
	private PhotoBoardService pbService;

	@RequestMapping(value="/photo/list1", method = RequestMethod.GET)
	public String goList() {
		return "photo/list";
	}
	@RequestMapping(value="/photo/write1",method = RequestMethod.GET)
	public String goWrite() {
		return "photo/write";
	}
	@RequestMapping(value="/photo/write1",method = RequestMethod.POST)
	public String doWrite(@ModelAttribute PhotoBoardVO pb, @RequestParam("pbFile") MultipartFile file) {
		pbService.insertPhotoBoard(file, pb);
		return "photo/write1";
	}
}
