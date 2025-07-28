package myjdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class JDBCTest3 {
	public static void main(String[] args) throws Exception {
		// db-info.properties
		// Class.forName("com.mysql.cj.jdbc.Driver");
		// Collection api class Map type이라는 말임
		Properties props = new Properties();
		FileReader fr = new FileReader("db-info.properties");
		props.load(fr);
		System.out.println(props.getProperty("url"));
	
	
	}

}
