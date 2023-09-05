package co.san.T20230905.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.san.T20230905.common.ViewResolve;



@WebServlet("/bookInfo.do")
public class BookInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BookInfo() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewName = "WEB-INF/views/bookInfo.html";
		ViewResolve.forward(request, response, viewName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
