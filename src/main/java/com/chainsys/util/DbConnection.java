package com.chainsys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimeZone;

public class DbConnection {
	public static Connection getConnection() throws Exception{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String server = "localhost";
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", "system",
						"oracle");
				return connection;
			}
		}
