/*
 * 작성일자(Create Date): 2020-10-15
 * 프로젝트명(Project Name): Community Project
 * 저자(Author): Dodo / rabbit.white at daum dot net
 * 파일명(FileName): SqlMapDataSourceFactory.java
 * 비고(Description):
 * 
 */

package com.community.website.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class SqlMapDataSourceFactory {

	private static final Logger logger = LoggerFactory.getLogger(SqlMapDataSourceFactory.class);
	
    private static String CLASSNAME;
    private static String JDBC_URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static int MAX_POOL_SIZE;
    private static String CACHE_PREP_STMTS;
    private static String PREP_STMT_CACHE_SIZE;
    private static String PREP_STMT_CACHE_SQL_LIMIT;
    
	    
	public DataSource dataSource() {
		
		InputStream inputStream;
		String resource = "db.properties";
        Properties properties = new Properties();
        
        try {
        	
        	inputStream = getClass().getClassLoader().getResourceAsStream(resource);
            properties.load(inputStream);
            
            System.out.println(properties.getProperty("jdbcUrl"));
            System.out.println(properties.getProperty("dataSourceClassName"));
            
            
            CLASSNAME = properties.getProperty("ORACLE_DB_DRIVER");
            JDBC_URL = properties.getProperty("ORACLE_DB_URL");
            USERNAME = properties.getProperty("ORACLE_DB_USERNAME");
            PASSWORD = properties.getProperty("ORACLE_DB_PASSWORD");
            
            CACHE_PREP_STMTS = properties.getProperty("cachePrepStmts");
            PREP_STMT_CACHE_SIZE = properties.getProperty("prepStmtCacheSize");
            PREP_STMT_CACHE_SQL_LIMIT = properties.getProperty("prepStmtCacheSqlLimit");
            MAX_POOL_SIZE = Integer.valueOf( properties.getProperty("maxPoolSize") );
            
			HikariConfig hikariConfig = new HikariConfig();
			hikariConfig.setDriverClassName(CLASSNAME);
			hikariConfig.setJdbcUrl(JDBC_URL);
			hikariConfig.setUsername(USERNAME);
			hikariConfig.setPassword(PASSWORD);
			hikariConfig.setMaximumPoolSize(MAX_POOL_SIZE);
			//hikariConfig.setMaximumPoolSize(5);
			//hikariConfig.setConnectionTestQuery("SELECT 1");
			//hikariConfig.setPoolName("springHikariCP");
						
			HikariDataSource dataSource = new HikariDataSource(hikariConfig);
			
			return dataSource;
		
        } catch (IOException e) {
            e.printStackTrace();
        }
		
        return null;
		
	}
	
}
