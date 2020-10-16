/*
 * 작성일자(Create Date): 2020-10-15
 * 프로젝트명(Project Name): Community Project
 * 저자(Author): Dodo / rabbit.white at daum dot net
 * 파일명(FileName): HomeController.java
 * 비고(Description):
 * 
 */

package com.community.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.community.website.service.aop.MemberService;
import com.community.website.util.SecurityUtil;
import com.community.website.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/myhome")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private static final String code = "dodo";
	
	// AOP로 맴버 서비스 콜할 때 충돌남 (편리한 이면에 오류들)
	// @Autowired
	// @Qualifier("memberService")
	// private MemberServiceImpl memberService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletResponse res,
							 HttpServletRequest req) {
		logger.info("Welcome home! The client locale is {}.");
	
		ModelAndView mav = new ModelAndView();		

		mav.addObject("pageTitle", "MyHome");
		mav.addObject("contextPath", req.getContextPath());
		mav.addObject("token", SecurityUtil.generateSHA512(code));
		
		mav.setViewName("/sign-in/login");
		return mav;
	}
	
	@RequestMapping(value = "authorize", method = RequestMethod.POST)
	public ModelAndView authorize(HttpServletResponse res,
									HttpServletRequest req) {
		
		logger.info("Authorize - MyHome Communities");
	
		MemberVO memberVO = new MemberVO();
		ModelAndView mav = new ModelAndView();
		
		memberVO.setUsername(req.getParameter("username"));
		memberVO.setPasswd(req.getParameter("passwd"));
		
		String token = req.getParameter("token");
		
		// 재사용 가능함 (Spring AOP - 수작업 노가다)
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		MemberService memberAOP = (MemberService) factory.getBean(MemberService.class);
//		rAOP.test();
		//memberAOP.test2();
		
		int result = memberAOP.authorize(memberVO, token);
		factory.close();
		
		mav.addObject("contextPath", req.getContextPath());
		
		if ( result == 0 ) {
			mav.setViewName("redirect:/myhome/main");
		}else {
			mav.setViewName("redirect:/myhome/login");
		}
		
		return mav;
	}
	
}
