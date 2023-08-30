package co.san.example.ajaxmember.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.san.example.ajaxmember.map.MembersMapper;
import co.san.example.ajaxmember.service.MembersService;
import co.san.example.ajaxmember.service.MembersVO;
import co.san.example.common.DataSources;

public class MembersServiceImpl implements MembersService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	MembersMapper map = sqlSession.getMapper(MembersMapper.class);
	@Override
	public boolean addMember(MembersVO vo) {
		
		return map.insert(vo) == 1;
	}
	@Override
	public boolean editMember(MembersVO vo) {
		
		return map.update(vo) == 1;
	}
	@Override
	public boolean deleteMember(int mbrId) {
		
		return map.delete(mbrId) == 1;
	}
	@Override
	public List<MembersVO> listMember() {
		
		return map.list();
	}

	

}
