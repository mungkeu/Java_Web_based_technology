package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login4")
public class LoginServlet4 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("doget 메서드 호출");
		doHandle(request, response); // GET 방식으로 요청 시 다시 doHandle()을 호출한다.
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("doPost 메서드 호출");
		doHandle(request, response); // Post 방식으로 요청 시 다시 doHandle()을 호출한다.
	}
	
	// 모든 호출 방식에 대해서 처리할 수 있다.
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		System.out.println("doHandle 메서드 호출");
		String user_pw = request.getParameter("user_pw");
		System.out.println("아이디:" + user_id);
		System.out.println("비밀번호:" + user_pw);
	}
	
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
