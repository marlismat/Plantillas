package com.digitel.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;


public class ReadProperties  implements Serializable {
	
	private static final long serialVersionUID = -3945391133144888980L;

	public static Properties getProperties(String nameProperties) throws FileNotFoundException, IOException{

		//Example:		
		//		Properties appProps = ReadProperties.GetProperties("fts-back.properties");
		
		StringBuilder proper = new StringBuilder();
		proper.append(Thread.currentThread().getContextClassLoader().getResource("").getPath());
		proper.append(nameProperties);
		String appConfigPath = proper.toString();
		
		Properties appProps = new Properties();
		appProps.load(new FileInputStream(appConfigPath));
		
		return appProps;

	}
}