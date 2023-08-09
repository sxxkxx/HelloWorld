package co.san.example.notice.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.san.example.notice.service.NoticeService;
import co.san.example.notice.service.NoticeVO;
import co.san.example.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/ajaxnoticesearch.do")
public class AjaxNoticeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxNoticeSearch() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<>();

		String key = request.getParameter("key");
		String val = request.getParameter("val");
		notices = dao.noticeSearchList(key, val);

		ObjectMapper objectMapper = new ObjectMapper(); // json 객체를 만들기 위해 필요한 객체

		objectMapper.registerModule(new JavaTimeModule()); // LocalDate 처리
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // LocalDate 처리

		String data = objectMapper.writeValueAsString(notices); // json 형태로 결과를 만들어 줌

		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append(data);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
