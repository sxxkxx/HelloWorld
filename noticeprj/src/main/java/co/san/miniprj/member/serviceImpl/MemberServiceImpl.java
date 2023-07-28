package co.san.miniprj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.san.miniprj.member.service.MemberService;
import co.san.miniprj.member.service.MemberVO;
import co.san.noticeprj.common.DataSource;

public class MemberServiceImpl implements MemberService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelectList() {
		String sql = "SELECT * FROM MEMBER";
		List<MemberVO> members = new ArrayList();
		MemberVO vo;

		try { // 여기서 DB 처리.
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAge(rs.getInt("member_age"));
				vo.setMemberGender(rs.getString("member_gender"));
				vo.setMemberTel(rs.getNString("member_tel"));
				vo.setMemberAddr(rs.getString("member_addr"));
				members.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return members;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";

		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberPw(rs.getString("member_pw"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAge(rs.getInt("member_age"));
				vo.setMemberGender(rs.getString("member_gender"));
				vo.setMemberTel(rs.getNString("member_tel"));
				vo.setMemberAddr(rs.getString("member_addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int n = 0;
		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPw());
			psmt.setString(3, vo.getMemberName());
			psmt.setInt(4, vo.getMemberAge());
			psmt.setString(5, vo.getMemberGender());
			psmt.setString(6, vo.getMemberTel());
			psmt.setString(7, vo.getMemberAddr());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		int n = 0;
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
