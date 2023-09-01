package co.san.example.notice.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.san.example.notice.service.ReplyService;
import co.san.example.notice.service.ReplyVO;
import co.san.example.notice.serviceImpl.ReplyServiceImpl;

@WebServlet("/AjaxDataTable.do")
public class AjaxDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxDataTable() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReplyService svc = new ReplyServiceImpl();
		Map<String, Object> map = new HashMap<>();
		List<ReplyVO> list = svc.replyList(7);
		
		map.put("data", list);
		
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
