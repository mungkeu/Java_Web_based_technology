package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		// Cookie ��ü�� ������ �� cookieTest �̸����� �ѱ� ������ ���ڵ��ؼ� ��Ű�� �����Ѵ�.
		Cookie c = new Cookie("cookieTest",URLEncoder.encode("JSP���α׷����Դϴ�.","utf-8"));
		// c.setMaxAge(-1);
		c.setMaxAge(-1); // ��ȿ �ð��� ������ ������ Session ��Ű�� �����.
		response.addCookie(c);
		out.println("����ð� : "+ d+"<br>");
		out.println("���ڿ��� Cookie�� �����Ѵ�.");
	}
}