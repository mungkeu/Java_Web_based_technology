package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/Login2")
public class LoginServlet2 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 웹 브라우저에서 전송된 데이터의 인코딩을 설정
		request.setCharacterEncoding("utf-8");
		// setContentType()을 이용해 응답할 데이터 종류가 HTML로 설정, 응답해줄때에도 utf-8로 설정해서 응답
		response.setContentType("text/html;charset=utf-8");
		// HttpServletResponse 객체의 getWriter()를 이용해 출력 스트림 PrintWriter객체를 받아온다.
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		String data = "<html>";
		data += "<body>";
		data += "아이디: " + id;
		data += "<br>";
		data += "패스워드: " + pw;
		data += "</body>";
		data += "</html>";
		out.print(data);
	}

}
