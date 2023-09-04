package co.san.example.todo.service;

import java.util.Date;

import lombok.Data;

@Data
public class TodoVO {
	private int todoNo;
	private String todo;
	private Date dueDate;
	private String complete;
}
