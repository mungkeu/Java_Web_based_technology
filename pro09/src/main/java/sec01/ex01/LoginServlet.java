package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		// hidden 태그로 전송된 데이터를 가져온다.
		String user_address = request.getParameter("user_address");
		String user_eail = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		String data="안녕하세요!<br> 로그인하셨습니다.<br><br>";
		data+="<html><body>";
		data+="아이디 : " + user_id;
		data+="<br>";
		data+="패스워드 : " + user_pw;
		data+="<br>";
		data+="주소 : " + user_address;
		data+="<br>";
		data+="이메일 : " + user_eail;
		data+="<br>";
		data+="휴대전화 : " + user_hp;
		data+="</body></html>";
		out.print(data);
	}
}
