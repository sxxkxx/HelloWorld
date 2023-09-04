package co.san.example.todo.map;

import java.util.List;

import co.san.example.todo.service.TodoVO;

public interface TodoMapper {
	public int insert(TodoVO vo);

	public int update(TodoVO vo);

	public int delete(int todoNo);

	public TodoVO select(int todoNo);

	public List<TodoVO> selectList();
}
