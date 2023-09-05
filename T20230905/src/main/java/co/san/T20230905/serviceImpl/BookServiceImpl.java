package co.san.T20230905.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.san.T20230905.common.DataSources;
import co.san.T20230905.map.BookMapper;
import co.san.T20230905.service.BookService;
import co.san.T20230905.service.BookVO;

public class BookServiceImpl implements BookService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	BookMapper map = sqlSession.getMapper(BookMapper.class);

	@Override
	public boolean addBook(BookVO vo) {

		return map.insert(vo) == 1;
	}

	@Override
	public boolean editBook(BookVO vo) {

		return map.update(vo) == 1;
	}

	@Override
	public boolean deleteBook(String bkCode) {

		return map.delete(bkCode) == 1;
	}

	@Override
	public List<BookVO> BookList() {
		
		return map.selectList();
	}

}
