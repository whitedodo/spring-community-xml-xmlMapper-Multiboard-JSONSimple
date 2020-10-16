/*
 * 작성일자(Create Date): 2020-10-15
 * 프로젝트명(Project Name): Community Project
 * 저자(Author): Dodo / rabbit.white at daum dot net
 * 파일명(FileName): LogAdvisor.java
 * 비고(Description):
 * 
 */
package com.community.website.aop.member;

import org.aspectj.lang.ProceedingJoinPoint;

public interface LogAdvisor {

	public void beforeAdvice();
	public void afterAdvice();
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable;
	public void afterThrowing();
	public void afterReturning();
}
