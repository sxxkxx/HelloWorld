package co.san.T20230905.service;

import java.util.List;


public interface BookService {
	public boolean addBook(BookVO vo);

	public boolean editBook(BookVO vo);

	public boolean deleteBook(String bkCode);

	public List<BookVO> BookList();
}
