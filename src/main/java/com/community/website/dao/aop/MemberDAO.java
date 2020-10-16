/*
 * 작성일자(Create Date): 2020-10-15
 * 프로젝트명(Project Name): Community Project
 * 저자(Author): Dodo / rabbit.white at daum dot net
 * 파일명(FileName): MemberDAO.java
 * 비고(Description):
 * 
 */

package com.community.website.dao.aop;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.community.website.vo.*;

public interface MemberDAO {

	// 회원 불러오기 select
	public MemberVO selectMember(String idx);
	
	public MemberVO selectMailMember(MemberVO vo);
	
	// 회원 조회 list
	public List<MemberVO> selectAll();
	
	// 회원 갯수 조회
	public long selectCount();
	
	// 회원 추가 insert
	public void createMember(MemberVO vo);
	
	// 수정 update
	public void updateMember(MemberVO vo);
	
	// 삭제 delete
	public void removeMember(String idx);
	
}
