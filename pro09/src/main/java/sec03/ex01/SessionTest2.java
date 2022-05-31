package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess2")
public class SessionTest2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.println("���� ���� ���� �ð�: " + new Date(session.getCreationTime()) + "<br>");
		out.println("���� ���� ���� �ð�: " + new Date(session.getLastAccessedTime()) + "<br>");
		
		// ��Ĺ�� �⺻ ���� ��ȿ �ð��� ����Ѵ�.
		out.println("�⺻ ���� ��ȿ �ð� : " + session.getMaxInactiveInterval()+"<br>");
		// ������ ��ȿ �ð��� 5�ʷ� �����Ѵ�.
		session.setMaxInactiveInterval(5);
		// ��ȿ �ð��� �缳���� �� ���� ��ȿ �ð��� ����Ѵ�.
		out.println("���� ��ȿ �ð� : " + session.getMaxInactiveInterval()+"<br>");
		if(session.isNew()) {
			out.print("�� ������ ����������ϴ�.");
		}
	}
}
