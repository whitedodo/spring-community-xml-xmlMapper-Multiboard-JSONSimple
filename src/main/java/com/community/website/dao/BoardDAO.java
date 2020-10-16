/*
 * 작성일자(Create Date): 2020-10-15
 * 프로젝트명(Project Name): Community Project
 * 저자(Author): Dodo / rabbit.white at daum dot net
 * 파일명(FileName): BoardDAO.java
 * 비고(Description):
 * 
 */

package com.community.website.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.community.website.vo.*;

public interface BoardDAO {

	// 게시판 상세 조회
	public BoardVO selectBoard(@Param("boardname")String boardname, 
							   @Param("id")long id);
	
	// 게시판 전체 갯수
	public long selectTotalCount(@Param("boardname")String boardname);
	
	// 게시판 전체 조회 list(X)
	public List<BoardVO> selectAll();
	
	// 게시판 페이징 조회
	public List<BoardVO> selectPagingAll(@Param("boardname") String boardname, 
										@Param("start") long start, 
										@Param("end") long end);
		
	// 게시판 내용 추가 insert
	public void insertBoard(BoardVO vo);
	
	// 셈플 DB 추가 시키기
	public void insertSample(String boardname);
	
	// 게시판 수정 update
	public void updateBoard(BoardVO vo);
	
	// 게시판 삭제 delete
	public void removeBoard(@Param("id") String id);
	
}
