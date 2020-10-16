/*
 * 작성일자(Create Date): 2020-10-15
 * 프로젝트명(Project Name): Community Project
 * 저자(Author): Dodo / rabbit.white at daum dot net
 * 파일명(FileName): MemberVO.java
 * 비고(Description):
 * 
 */

package com.community.website.vo;

import java.sql.Date;

public class MemberVO {
	
	private long idx;
	private String username;
	private String passwd;
	private Date regidate;
	
	// 주민등록 수집 자체를 안함.
	
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public Date getRegidate() {
		return regidate;
	}
	
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	
}
