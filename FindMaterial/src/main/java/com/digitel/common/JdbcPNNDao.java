package com.digitel.common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository("JdbcPNNDao")
@PropertySource("classpath:application.properties")
public class JdbcPNNDao {


	
	 private static JdbcTemplate jdbcPNNTemplate;
	 @Value( "${spring.datasource.url}" )
	 private String url;
	 @Value( "${spring.datasource.username}" )
	 private String username;
	 @Value( "${spring.datasource.password}" )
	 private String password;
	// @Value( "${spring.datasource.driver-class-name}" )
	// private String driver;	
	 @Value( "${spring.datasource.hikari.connection-timeout}" )
	 private int timeout;
	 @Value( "${spring.datasource.hikari.maximum-pool-size}" )
	 private int max;
	
	@Autowired
	public void setJdbcTemplate() {
		System.out.println("Prueba de valores de conexion set y get");
		System.out.println(url);				
		System.out.println(username);
		System.out.println(password);
	//	System.out.println(driver);	
		
		 BasicDataSource dataSource  = new BasicDataSource();	
		 dataSource.setUrl(url);
		 dataSource.setUsername(username);
		 dataSource.setPassword(password);
	//	 dataSource.setDriverClassName(driver);
		 dataSource.setDefaultQueryTimeout(timeout);
		 dataSource.setMaxTotal(max);
		 JdbcPNNDao.jdbcPNNTemplate = new JdbcTemplate(dataSource);
		 
		
//		 try {
//			 System.out.println("crea la instancia");
//			 Context initContext = new InitialContext();
//			 Context envContext  = (Context)initContext.lookup("java:/comp/env");
//			 DataSource ds = (DataSource)envContext.lookup("jdbc/pnnprod");
//			 JdbcPNNDao.jdbcPNNTemplate = new JdbcTemplate(ds);
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 
		
		// dataSource.setEnableAutoCommitOnReturn(false);
		// dataSource.setDefaultAutoCommit(false);
	}

	
	public static JdbcTemplate getJdbcTemplate() { // instancia en memoria
		System.out.println("toma la conexion");
		return jdbcPNNTemplate;
	}

	 
}

