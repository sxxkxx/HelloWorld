package co.san.T20230905.map;

import java.util.List;

import co.san.T20230905.service.BookVO;

public interface BookMapper {
	public int insert(BookVO vo);

	public int update(BookVO vo);

	public int delete(String bkCode);
	
	public List<BookVO> selectList();
}
