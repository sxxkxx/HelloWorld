package co.san.example.todo.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.san.example.common.DataSources;
import co.san.example.todo.map.TodoMapper;
import co.san.example.todo.service.TodoService;
import co.san.example.todo.service.TodoVO;

public class TodoServiceImpl implements TodoService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);
	TodoMapper map = sqlSession.getMapper(TodoMapper.class);
	
	@Override
	public boolean addTodo(TodoVO vo) {
		
		return map.insert(vo)==1;
	}

	@Override
	public boolean editTodo(TodoVO vo) {
		
		return map.update(vo)==1;
	}

	@Override
	public boolean deleteTodo(int todoNo) {
		
		return map.delete(todoNo)==1;
	}

	@Override
	public TodoVO getTodo(int todoNo) {
		
		return map.select(todoNo);
	}

	@Override
	public List<TodoVO> TodoList() {
		
		return map.selectList();
	}

}
