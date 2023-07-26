package co.yedam.hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleExe {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("OracleDriver 없음");
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "1234";

		Connection conn = null; // DB 연결 세션.
		try {
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB 연결 완료");

			// JAVA -> DB.
			String sql = "insert into emp_temp(emp_id, emp_name, email, address)";
			sql += "values(?,?,?,?)"; // PreparedStatement -> ?사용 십가능.
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, 1004);
			psmt.setString(2, "park");
			psmt.setString(3, "park@eamil.com");
			psmt.setString(4, "manchster");
			int r = psmt.executeUpdate(); // 처리된 건수 반환.
			System.out.println(r + "건 입력.");

			// DB -> JAVA.
			Statement stmt = conn.createStatement(); // 쿼리 실행 -> 결과 반환.
			ResultSet rs = stmt.executeQuery("select * from emp_temp"); // SQL명령어입력 -> 결과 반환.

			while (rs.next()) { // 리턴값(행 데이터)이 있으면 true, 없으면 false출력후 종료.
				System.out.println("id: " + rs.getInt("emp_id") + ", 이름: " + rs.getString("emp_name") + ", mail: "
						+ rs.getString("email"));
			}
			System.out.println("end of data.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		} finally {
			try {
				conn.close(); // DB 연결 세션 끝
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end of prog.");
	}

}
