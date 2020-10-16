/*
 * 작성일자(Create Date): 2020-10-15
 * 프로젝트명(Project Name): Community Project
 * 저자(Author): Dodo / rabbit.white at daum dot net
 * 파일명(FileName): BoardServiceImpl.java
 * 비고(Description):
 * 
 */

package com.community.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.community.website.dao.BoardDAO;
import com.community.website.vo.BoardVO;

@Repository("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public BoardVO select(String boardname, long id) {
		return boardDAO.selectBoard(boardname, id);
	}

	@Override
	public List<BoardVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long selectTotalCount(String boardname) {
		return boardDAO.selectTotalCount(boardname);
	}

	@Override
	public List<BoardVO> selectPagingAll(String boardname, long start, long end) {

		return boardDAO.selectPagingAll(boardname, start, end);
	}

	@Override
	public void insertSample(String boardname) {
		
		boardDAO.insertSample(boardname);
		
	}

}
