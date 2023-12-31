package co.san.example.notice.web;

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

import co.san.example.notice.service.ReplyService;
import co.san.example.notice.service.ReplyVO;
import co.san.example.notice.serviceImpl.ReplyServiceImpl;


@WebServlet("/AjaxReplyEdit.do")
public class AjaxReplyEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AjaxReplyEdit() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String replyId = request.getParameter("replyId");
		String reply = request.getParameter("reply");
		String replyer = request.getParameter("replyer");

		ReplyVO vo = new ReplyVO();
		vo.setReplyId(Integer.parseInt(replyId));
		vo.setReply(reply);
		vo.setReplyer(replyer);

		ReplyService service = new ReplyServiceImpl();
		Map<String , Object> map = new HashMap<String, Object>();
		if (service.editReply(vo)) {
			map.put("retCode", "Success");
			map.put("data", vo);
		}else {
			map.put("retCode", "Fail");
			map.put("data", "수정ㄴㄴㄴㄴㄴㄴㄴㄴ");
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
