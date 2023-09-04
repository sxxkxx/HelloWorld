package co.san.example.todo.service;

import java.util.List;


public interface TodoService {
	public boolean addTodo(TodoVO vo);

	public boolean editTodo(TodoVO vo);

	public boolean deleteTodo(int todoNo);

	public TodoVO getTodo(int todoNo);

	public List<TodoVO> TodoList();
}
