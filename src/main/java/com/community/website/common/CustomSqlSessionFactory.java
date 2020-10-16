/*
 * 작성일자(Create Date): 2020-10-15
 * 프로젝트명(Project Name): Community Project
 * 저자(Author): Dodo / rabbit.white at daum dot net
 * 파일명(FileName): CustomSqlSessionFactory.java
 * 비고(Description):
 * 
 */

package com.community.website.common;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

// import com.community.website.mapper.MemberMapper;

// AOP에서는 Inject(주입)이 안됨. (Proxy로 차단됨)
public class CustomSqlSessionFactory {

	private static SqlMapDataSourceFactory dsFactory = null;
	
	static {
		
		dsFactory = new SqlMapDataSourceFactory();
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		
		DataSource dataSource = dsFactory.dataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		
		// configuration.addMapper(MemberMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		return sqlSessionFactory;
		
	}
	
}
