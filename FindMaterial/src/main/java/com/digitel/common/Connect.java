package com.digitel.common;

import java.io.Serializable;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Connect implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6263398114927271350L;

public static Connection connectionOracle(String nameConection) throws Exception {
	
	Context initContext = new InitialContext();
	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup(nameConection);
	Connection conn = ds.getConnection();
	
	return conn;
}
	
	
}
