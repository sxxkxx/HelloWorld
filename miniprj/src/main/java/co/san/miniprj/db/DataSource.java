package co.san.miniprj.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource { // 싱글톤 패턴 (객체생성후 인스턴스로 반환).
	private static DataSource dataSource;
	private String driver;
	private String url; // (@localhost:1521:xe) 업체 제공.
	private String user;
	private String password;

	public static Connection conn;

	private DataSource() {
		try {
			getProperty();
			Class.forName(driver);

			System.out.println("DB 연결 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("DB 연결 실패");
		}
	}

	private void getProperty() { // db.properties 파일에서 정보를 가져옴.
		String resource = "/config/db.properties";
		Properties properties = new Properties();

		try {
			InputStream reader = getClass().getResourceAsStream(resource);
			properties.load(reader);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getInstance() {
		DataSource dataSource = new DataSource();
		return dataSource;
	}

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 완료");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		return conn;
	}
}
