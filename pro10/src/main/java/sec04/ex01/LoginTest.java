package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginTest extends HttpServlet {
	ServletContext context=null;
	List user_list=new ArrayList(); // 로그인한 접속자 ID를 저장하는 ArrayList
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		context=getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// 이벤트 핸들러를 생성한 후 세션에 저장한다.
		LoginImpl loginUser = new LoginImpl(user_id,user_pw);
		
		if(session.isNew()) {
			// 세션에 바인딩 시 LoginImpl의 valueBound()메서드를 호출한다.
			session.setAttribute("loginUser", loginUser);
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}

		out.println("<html><body>");
		out.println("아이디는 " + user_id + "<br>");
		// 세션에 바인딩 이벤트 처리 후 총 접속자수를 표시한다.
		out.println("총 접속자수는 " + LoginImpl.total_user + "<br><br>");
		out.println("접속 아이디:<br>");
		// context 객체의 ArrayList를 가져와 접속자 ID를 차례로 브라우저로 출력한다.
		List list=(ArrayList)context.getAttribute("user_list");
		for(int i=0; i<list.size(); i++)
		{
			out.println(list.get(i)+"<br>");
		}
		// 로그아웃 클릭 시 서블릿 logout으로 접속자 ID를 전송해 로그아웃한다.
		out.println("<a href='logout?user_id="+user_id+"'>로그아웃</a>");
		out.println("</body></html>");
	}
}
