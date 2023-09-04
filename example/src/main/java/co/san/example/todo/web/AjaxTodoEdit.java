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

@WebServlet("/jquery/AjaxTodoEdit.do")
public class AjaxTodoEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxTodoEdit() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TodoService service = new TodoServiceImpl();
		TodoVO vo = new TodoVO();
		Map<String, Object> map = new HashMap<String, Object>();
		String complete = request.getParameter("complete");
		String todoNo = request.getParameter("todoNo");
		
		System.out.println(complete);
		vo.setComplete(complete);
		vo.setTodoNo(Integer.parseInt(todoNo));
		if (service.editTodo(vo)) {
			map.put("retCode", "Success");
			map.put("data", vo);
		} else {
			map.put("retCode", "Fail");
			map.put("data", "수정ㄴㄴㄴㄴㄴㄴㄴㄴ");
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
