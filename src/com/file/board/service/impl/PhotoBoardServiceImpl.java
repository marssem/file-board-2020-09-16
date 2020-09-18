package com.file.board.service.impl;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.file.board.dao.PhotoBoardDAO;
import com.file.board.service.PhotoBoardService;
import com.file.board.vo.PageVO;
import com.file.board.vo.PhotoBoardVO;

@Service("pbService")
public class PhotoBoardServiceImpl implements PhotoBoardService {
	
	@Autowired
	private PhotoBoardDAO pbDAO;
	private final String uploadPath = "C:\\java_study\\workspace\\file-board\\WebContent\\resources\\";
	//BasicDataSource
	@Override
	public int insertPhotoBoard(MultipartFile file, PhotoBoardVO pb) {
//		System.out.println(file.getOriginalFilename());
//		System.out.println(pb);
		
		String orgFileName = file.getOriginalFilename();
		String extName = orgFileName.substring(orgFileName.lastIndexOf("."));
		String fileName = System.nanoTime() + extName;
		pb.setPbPhotoName(orgFileName);
		pb.setPbPhotoPath(fileName);
		int cnt = pbDAO.insertBoard(file, pb);
		if(cnt==1) {
			File f = new File(uploadPath+fileName);
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		return pbDAO.insertBoard(file, pb);
		return cnt;
	}
	
	@Override
	public List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb, Model model) {
		PageVO page = new PageVO();
		if(page.getPageNum()==0) {
			page.setPageNum(1);
			System.out.println("page 1: "+page.getPageNum());
		}else {
			System.out.println("service pb : "+page.getPageNum());
			page.setPageNum(page.getPageNum());
		}
		
			System.out.println("page other : "+page.getPageNum());
		
		
		
		int startNum = (page.getPageNum()-1)*10+1;
		int endNum = startNum +(10-1);
		page.setStartNum(startNum);
		page.setEndNum(endNum);
		/*
		 *
		 * model.addAttribute("pbList",pbDAO.selectPhotoBoardList(pb));
		 */
		int totalCnt = pbDAO.selectPhotoBoardCount(pb);
		page.setTotalPage(totalCnt);
		int totalPageSize = totalCnt/10;
		int startBlock = (page.getPageNum()-1)/10 * 10 +1;
		int endBlock = startBlock + (10-1);
		if(endBlock>totalPageSize){
			endBlock = totalPageSize;
		}
		page.setStartBlock(startBlock);
		page.setEndBlock(endBlock);
		
		 pb.setPage(page);
		model.addAttribute("page", page);
		model.addAttribute("pbList", pbDAO.selectPhotoBoardList(pb));
		
		return null;
	}

	@Override
	public int deletePhotoBoards(int[] pbNums) {
		List<PhotoBoardVO> pbList = pbDAO.selectPhotoBoardsForDelete(pbNums);
		System.out.println("service!!");
		if(!pbList.isEmpty()) {
			for(PhotoBoardVO pb:pbList) {
				System.out.println("service pblist: "+pb);

				String fileName = pb.getPbPhotoPath();
				File f = new File(uploadPath+fileName);
				System.out.println("service f : "+ f);
				if(f.exists()) {
					f.delete();
				}
			}
		}
		return pbDAO.deletePhotoBoards(pbNums);
	}

	@Override
	public int updatePhotoBoard(MultipartFile file, PhotoBoardVO pb) {
		PageVO page = new PageVO();
		String orgFileName = file.getOriginalFilename();
		String extName = orgFileName.substring(orgFileName.lastIndexOf("."));
		String fileName = System.nanoTime() + extName;
		pb.setPbPhotoName(orgFileName);
		pb.setPbPhotoPath(fileName);
		int cnt = pbDAO.updatePhotoBoard(file, pb);
		if(cnt==1) {
			int[] pbNum = {pb.getPbNum()};
			List<PhotoBoardVO> pbList = pbDAO.selectPhotoBoardsForDelete(pbNum);
			File f = new File(uploadPath+fileName);
			if(!pbList.isEmpty()) {
				for(PhotoBoardVO pbvo:pbList) {
					System.out.println("service pblist: "+pb);

					String newfileName = pb.getPbPhotoPath();
					File fi = new File(uploadPath+newfileName);
					System.out.println("service f : "+ f);
					if(fi.exists()) {
						fi.delete();
					}
				}
			}
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

}
