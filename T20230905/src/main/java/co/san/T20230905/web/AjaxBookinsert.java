package co.san.T20230905.web;

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

import co.san.T20230905.service.BookService;
import co.san.T20230905.service.BookVO;
import co.san.T20230905.serviceImpl.BookServiceImpl;


@WebServlet("/AjaxBookinsert.do")
public class AjaxBookinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxBookinsert() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookService service = new BookServiceImpl();
		BookVO vo = new BookVO();
		
		String bkCode = request.getParameter("bkCode");
		String bkTitle = request.getParameter("bkTitle");
		String bkAuthor = request.getParameter("bkAuthor");
		String bkPress = request.getParameter("bkPress");
		String bkPrice = request.getParameter("bkPrice");
		vo.setBkCode(bkCode);
		vo.setBkTitle(bkTitle);
		vo.setBkAuthor(bkAuthor);
		vo.setBkPress(bkPress);
		vo.setBkPrice(Integer.parseInt(bkPrice));
		
		
		Map<String , Object> map = new HashMap<String, Object>();
		if(service.addBook(vo)) {
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
