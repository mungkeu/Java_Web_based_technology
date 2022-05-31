package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pw");
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		MemberDAO dao = new MemberDAO();
		boolean result = dao.isExisted(memberVO);
		if(result)
		{
			HttpSession session = request.getSession();
			// 조회한 결과가 true이면 isLogOn 속성을 true로 세션에 저장한다.
			session.setAttribute("isLogon", true);
			// 조회한 결과가 true이면 ID와 비밀번호 를 세션에 저장합니다.
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);
			out.print("<html><body>");
			out.print("안녕하세요 " + user_id + "님!!!");
			out.print("<a href='show'>회원정보 보기</a>");
			out.print("</body></html>");
		} else {
			out.print("<html><body><center>회원 아이디가 틀립니다.<br>");
			out.print("<a href='login3.html'>다시 로그인하기</a>");
			out.print("</body></html>");
		}
	}
}