package co.san.example.todo.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.san.example.todo.service.TodoService;
import co.san.example.todo.service.TodoVO;
import co.san.example.todo.serviceImpl.TodoServiceImpl;

@WebServlet("/jquery/AjaxTodoinsert.do")
public class AjaxTodoinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxTodoinsert() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TodoService service = new TodoServiceImpl();
		TodoVO vo = new TodoVO();
		
		String todo = request.getParameter("todo");
		String complete = "NO";
		vo.setTodo(todo);
		vo.setComplete(complete);
		
		Map<String , Object> map = new HashMap<String, Object>();
		if(service.addTodo(vo)) {
			map.put("retCode", "Success");
			map.put("data", vo);
		}else {
			map.put("retCode", "Fail");
			map.put("data", "등록ㄴㄴㄴㄴㄴㄴㄴㄴ");
		}
		
		Gson gson = new GsonBuilder().create();

		String json = gson.toJson(map);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
