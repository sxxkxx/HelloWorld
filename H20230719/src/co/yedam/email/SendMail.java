package co.yedam.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	// 메일 계정
	/*
	 * Gmail의 경우 google 내 계정 - 보안 - 2차 인증 활성화 이후 발급 가능한 앱 비밀번호를 발급받아야 함
	 */
	private static String user = "seuld1521@gmail.com";
	private static String password = "wgqoatyrqlbcjixc";

	public static void send() {

		// SMTP 서버 정보 설정
		// TLSv1.2 추가하여 신뢰성 확보
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);

			// 발신자 정보
			message.setFrom(new InternetAddress(user, "김태산"));

			// 수신자 메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("lacrecia@naver.com"));

			// 메일 제목
			message.setSubject("김태산 JAVA로 메일 보내기."); // 메일 제목을 입력

			// 메일 내용
			message.setText("안녕하십니까, 교수님\n"
					+ "\n"
					+ "클라우드(AWS) 활용 Java 개발자 양성 과정을 수강 중인 김태산입니다.\n"
					+ "\n"
					+ "감사합니다.\n"
					+ "\n"
					+ "- 이 메일은 JAVA에서 작성되었습니다. -");

			// 메일 전송
			Transport.send(message);
			System.out.println("메일 전송 완료");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
