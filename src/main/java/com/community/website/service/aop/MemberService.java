/*
 * 작성일자(Create Date): 2020-10-15
 * 프로젝트명(Project Name): Community Project
 * 저자(Author): Dodo / rabbit.white at daum dot net
 * 파일명(FileName): MemberService.java
 * 비고(Description):
 * 
 */

package com.community.website.service.aop;

import java.sql.Date;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.community.website.dao.aop.MemberDAO;
import com.community.website.dao.aop.MemberDAOImpl;
import com.community.website.util.SecurityUtil;
import com.community.website.vo.MemberVO;

// 인터페이스 사용불가(AOP 적용시)
public class MemberService {

	// 임시 보안 처리
	private String token_code = "dodo";
	
	public void test() {
		System.out.println("중간");
	}
	
	public int test2() {
		System.out.println("중간-정수형");
		return 2;
	}
	
	public void test3() {

		/*
		SqlMapDataSourceFactory sFactory = new SqlMapDataSourceFactory();
		DataSource ds = sFactory.dataSource();
		
		if ( ds == null) {
			System.out.println("데이터소스는 닫혔다.");
		}
		
		try {
			System.out.println("데이터소스가 열렸다.");
			System.out.println(ds.getConnection().toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	// AOP 사용할 때, boolean 사용하면 안 됨
	public int authorize(MemberVO vo, String token) {
		
		MemberVO current = null;
		MemberDAO memberDAO = new MemberDAOImpl();

		String msgPack = null;
		int result = 1;
				
		long count = memberDAO.selectCount();
		current = memberDAO.selectMailMember(vo);
		
		String email = null;
		String passwd = null;
		
		// System.out.println(count);
		System.out.println("비즈니스 로그인 핵심 - 코어 구현");
		
		// 1차 인증
		if ( count > 0 && current != null) {
			email = current.getUsername();
			passwd = current.getPasswd();	
		}
		
		// 신규 관리자 계정 생성
		if (count == 0) {
			MemberVO node = new MemberVO();
			node.setUsername("rabbit.white@localhost.com");
			msgPack = SecurityUtil.generateSHA512("123456");
			
			node.setPasswd(msgPack);
			node.setRegidate(Date.valueOf("2020-03-01"));

			// System.out.println("계정 생성");
			// DB 초기 계정 생성하기
			memberDAO.createMember(node);
			
			result = 0;
		}
		
		// 2차 - 세션 토큰 
		// 인증 절차 [md5: 취약함. AES256, AES128, 각종 암호들)
		if ( !token.contentEquals(token_code)) {
			result = 0;
		}
		
		return result;
		
	}
	
}
