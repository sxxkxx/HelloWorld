package co.yedam.email;

import java.util.Properties;

public class MailSender {

	public static void main(String[] args) {
		String title = "메일 보내기 test 메일";
		String content = "메일 보내기 test 메일 입니다.";
		String user_name = "lacrecia@naver.com";
		String password = "wgqoatyrqlbcjixc";
		
		

		SendMail sendMail = new SendMail();
		sendMail.send();
//		sendMail.goMail(sendMail.setting(new Perties(), user_name, password), title, content);
		
		
		
	}

}
