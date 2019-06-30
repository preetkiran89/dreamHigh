package com.online.bus.database;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.core.env.Environment;

public class Database 
{	
	private static BasicDataSource ds = null;
	
	private Database() {}
	
	private static void initDataSource(Environment env){
		ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("DRIVER_NAME"));
		ds.setUrl(env.getProperty("URL"));
		ds.setUsername(env.getProperty("USERNAME"));
		ds.setPassword(env.getProperty("PASSWORD"));
		ds.setMinIdle(Integer.parseInt(env.getProperty("MIN_IDLE")));
		ds.setMaxIdle(Integer.parseInt(env.getProperty("MAX_IDLE")));
		ds.setMaxTotal(Integer.parseInt(env.getProperty("MAX_TOTAL")));
		ds.setMaxWaitMillis(Integer.parseInt(env
				.getProperty("MAX_WAIT_MILLISECONDS")));
	}
	
	public static Connection getConnection(Environment env) throws SQLException {
		if (ds == null) {
			initDataSource(env);
		}
		return ds.getConnection();
	}
	
}
