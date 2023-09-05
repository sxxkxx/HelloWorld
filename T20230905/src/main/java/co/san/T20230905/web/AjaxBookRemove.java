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
import co.san.T20230905.serviceImpl.BookServiceImpl;

@WebServlet("/AjaxBookRemove.do")
public class AjaxBookRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AjaxBookRemove() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = new BookServiceImpl();
		Map<String , Object> map = new HashMap<String, Object>();
		String bkCode = request.getParameter("bkCode");
		
		if (service.deleteBook(bkCode)) {
			map.put("retCode", "Success");
			map.put("data", "삭제완료");
		}else {
			map.put("retCode", "Fail");
			map.put("data", "삭제완료ㄴㄴ");
		}
		
		Gson gson = new GsonBuilder().create();

		String json = gson.toJson(map);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
