package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/login")
public class SessionTest5 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		// 로그인창에서 전송된 ID와 비밀번호를 가져온다.
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		if(session.isNew()) { // 최초 요청 시 수행한다.
			
			// 로그인창에서 서블릿으로 요청했다면 ID가 null이 아니므로 세션에 ID를 바인딩한다.
			if(user_id!=null) { 
				session.setAttribute("user_id", user_id);
				
				// 변수 url에 encodeURL()을 이용해 응답 시 미리 jsessionId을 저장한다.
				String url=response.encodeURL("login");
				// 로그인 상태 확인 클릭 시 jsessionId를 서블릿으로 다시 전송한다.
				out.println("<a href='"+url+"'>로그인 상태 확인</a>");
				
			} else {
				out.println("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}else {
			// 재요청 시 세션에서 ID를 가져와 이전에 로그인했는지 여부를 확인한다.
			user_id = (String)session.getAttribute("user_id");
			if(user_id!=null&&user_id.length()!=0) {
				out.print("안녕하세요 " + user_id + "님!!!");
			}else {
				out.print("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}
	}
}