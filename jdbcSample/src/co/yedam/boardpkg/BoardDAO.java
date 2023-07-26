package co.yedam.boardpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO implements BoardService {

	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs;

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

	@Override
	public boolean login(String id, String pw) {
		getConn();
		String sql = "select user_pw from users where user_id=?";
		String pwc = "";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				pwc = rs.getString("user_pw");
			}
			if (pwc.equals(pw)) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("안뎀");
		} finally {
			disconn();
		}

		return false;
	}

	@Override
	public boolean addBoard(Board board) {
		String sql = "insert into boards(board_no, title, content, writer, write_date)";
		sql += "values(?,?,?,?,?)"; // PreparedStatement -> ?에 값 입력.
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBrdNo());
			psmt.setString(2, board.getTitle());
			psmt.setString(3, board.getContent());
			psmt.setString(4, board.getWriter());
			psmt.setString(5, board.getWriteDate());
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

	@Override
	public boolean editBoard(Board board) {
		getConn();
		String sql = "update boards set title =?, content =? where board_no=? and writer=? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBrdNo());
			psmt.setString(4, board.getWriter());
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}

		return false;
	}

	@Override
	public boolean delBoard(int brdNo, String Writer) {
		getConn();
		String sql = "delete boards where board_no=? and writer=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brdNo);
			psmt.setString(2, Writer);
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Board> boardList() {
		String sql = "select * from boards order by board_no";
		List<Board> bList = new ArrayList<>();
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Board bd = new Board();
				bd.setBrdNo(rs.getInt("board_no"));
				bd.setTitle(rs.getString("title"));
				bd.setContent(rs.getString("content"));
				bd.setWriter(rs.getString("writer"));
				bd.setWriteDate(rs.getString("write_date"));

				bList.add(bd);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return bList;
	}

	@Override
	public boolean modInfo(User user) {
		String sql = "update users set user_pw =? where user_id=?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserPw());
			psmt.setString(2, user.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public int getNextBoardNo() {
		String sql = "select ? from boards";
		int result = 1;
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "nvl(max(board_no),0)");
			rs = psmt.executeQuery();
			while (rs.next()) {
				result = (rs.getInt("nvl(max(board_no),0)") + 1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}

		return result;
	}
}
