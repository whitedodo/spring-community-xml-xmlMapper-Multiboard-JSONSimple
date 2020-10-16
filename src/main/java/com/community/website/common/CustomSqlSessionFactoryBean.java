/*
 * 작성일자(Create Date): 2020-10-15
 * 프로젝트명(Project Name): Community Project
 * 저자(Author): Dodo / rabbit.white at daum dot net
 * 파일명(FileName): CustomSqlSessionFactoryBean.java
 * 비고(Description):
 * 
 */

package com.community.website.common;

import java.io.Reader;
import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources; // ibatis 는 pom.xml에 주입해줘야한다.
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomSqlSessionFactoryBean {
	
	private static SqlSessionFactory sessionFactory = null;
	
    public static SqlSession getSqlSessionInstance() {
    	
    	DataSource ds = new SqlMapDataSourceFactory().dataSource();
    	Connection conn = null;
    	try {
    		
    		 conn = ds.getConnection();
    		
            if(sessionFactory == null) {
                Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
                sessionFactory = new SqlSessionFactoryBuilder().build(reader);
               
                
                // 설정 정보 읽고 객체 생성
                //System.out.println("참:익었다.");
            }
            
        }catch(Exception e) {
            //System.out.println("오류 내용: " + e);
        }
    	
    	if ( sessionFactory.openSession(conn) != null ) {
    		//System.out.println("정상적인 세션 팩토리");
    	}else {
    		//System.out.println("비정상적인 세션 팩토리");
    	}
    	
        return sessionFactory.openSession(conn); // SessionFactory에서 SqlSession 얻어오기
        
    }
}
