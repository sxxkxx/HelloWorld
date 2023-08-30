package co.san.testtemplate.home.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.san.example.member.service.MemberService;
import co.san.example.member.serviceImpl.MemberServiceImpl;
import co.san.testtemplate.common.ViewResolve;

@WebServlet("/about.do")
public class AboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AboutController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		List<HashMap<String, Object>> list = new ArrayList<>();
		
		String viewName = "home/about";
		ViewResolve.forword(request, response, viewName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
