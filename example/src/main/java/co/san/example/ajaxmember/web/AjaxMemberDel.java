package co.san.example.ajaxmember.web;

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

import co.san.example.ajaxmember.service.MembersService;
import co.san.example.ajaxmember.serviceImpl.MembersServiceImpl;

@WebServlet("/AjaxMemberDel.do")
public class AjaxMemberDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxMemberDel() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,Object> map = new HashMap<>();
		MembersService service = new MembersServiceImpl();
		int delNo = Integer.parseInt(request.getParameter("delNo"));
		System.out.println(delNo);
		if (service.deleteMember(delNo)) {
			map.put("retCode", "Success");
			map.put("result", "삭제됨");
		} else {
			map.put("retCode", "Fail");
			map.put("result", "등록 중 에러.");
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
