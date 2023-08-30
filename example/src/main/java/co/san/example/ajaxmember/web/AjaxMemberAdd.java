package co.san.example.ajaxmember.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.san.example.ajaxmember.service.MembersService;
import co.san.example.ajaxmember.service.MembersVO;
import co.san.example.ajaxmember.serviceImpl.MembersServiceImpl;

@WebServlet("/AjaxMemberAdd.do")
public class AjaxMemberAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxMemberAdd() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String age = request.getParameter("age");

		// json 문자열.
		request.getInputStream();
		ServletInputStream sis = request.getInputStream();
		byte[] buf = new byte[100];

		

		StringBuffer sb = new StringBuffer();
		while (true) {
			int size = sis.read(buf);
			if (size == -1) {
				break;
			}
			sb.append(new String(buf, 0, size));
		}
		System.out.println(sb.toString());
		String json = sb.toString();
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(json);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		no = (String) obj.get("no");
		name = (String) obj.get("name");
		phone = (String) obj.get("phone");
		age = (String) obj.get("age");

		MembersVO vo = new MembersVO(Integer.parseInt(no), name, phone, Integer.parseInt(age));
		MembersService service = new MembersServiceImpl();
		// {"retCode":"Success","result":vo}
		// {"retCode":"Fail", "result":"등록중 에러."
		Map<String, Object> map = new HashMap<String, Object>();

		if (service.addMember(vo)) {
			map.put("retCode", "Success");
			map.put("result", vo);
		} else {
			map.put("retCode", "Fail");
			map.put("result", "등록 중 에러.");
		}
		Gson gson = new GsonBuilder().create();
		json = gson.toJson(map);

		response.setContentType("text/json;charset=utf-8");
		
		response.getWriter().print(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
