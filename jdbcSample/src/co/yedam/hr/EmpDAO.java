package co.yedam.hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//data access object.
public class EmpDAO {

	Connection conn = null; // DB 연결 세션.
	PreparedStatement psmt;
	ResultSet rs; // 결과 반환.

	// DB 연결.
	void getConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("OracleDriver 없음");
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "1234";

		try {
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DB 연결 종료.
	void disconn() {
		try {
			if (conn != null)
				conn.close();

			if (psmt != null)
				psmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {

		}
	}

	// 입력
	boolean addEmp(EmpVo emp) {
		String sql = "insert into emp_temp(emp_id, emp_name, email, address, salary)";
		sql += "values(?,?,?,?,?)"; // PreparedStatement -> ?에 값 입력.
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmpId());
			psmt.setString(2, emp.getEmpName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getAddress());
			psmt.setInt(5, emp.getSalary());
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 목록
	List<EmpVo> empList() {
		String sql = "select * from emp_temp order by emp_id";
		getConn();
		List<EmpVo> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				EmpVo vo = new EmpVo();
				vo.setEmpId(rs.getInt("emp_id"));
				vo.setEmpName(rs.getString("emp_name"));
				vo.setEmail(rs.getString("email"));
				vo.setAddress(rs.getString("address"));
				vo.setSalary(rs.getInt("salary"));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// 수정
	boolean editEmp(EmpVo emp) {
		String sql = "update emp_temp set address=?, email=? where emp_id=?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getAddress());
			psmt.setString(2, emp.getEmail());
			psmt.setInt(3, emp.getEmpId());
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	// 삭제
	boolean delEmp(int empId) {
		String sql = "delete emp_temp where emp_id=?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	// 단건 조회
	EmpVo getEmp(int empId) {
		EmpVo emp = new EmpVo();
		String sql = "select * from emp_temp where emp_id=?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs = psmt.executeQuery();
			while (rs.next()) {

				emp.setEmpId(rs.getInt("emp_id"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmail(rs.getString("email"));
				emp.setAddress(rs.getString("address"));
				emp.setSalary(rs.getInt("salary"));
				return emp;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
