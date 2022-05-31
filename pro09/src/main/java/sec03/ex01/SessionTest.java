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

@WebServlet("/sess")
public class SessionTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ���� ��û �� ���� ��ü�� ���� �����ϰų� ���� ������ ��ȯ�Ѵ�.
		HttpSession session = request.getSession();
		// ������ ���� Id�� �����´�.
		out.println("���� ���̵�: " + session.getId() + "<br>");
		// ���� ���� ��ü ���� �ð��� �����´�.
		out.println("���� ���� ���� �ð�: " + new Date(session.getCreationTime()) + "<br>");
		// ���� ��ü�� ���� �ֱٿ� ������ �ð��� �����´�.
		out.println("���� ���� ���� �ð�: " + new Date(session.getLastAccessedTime()) + "<br>");
		// ���� ��ü�� ���� �ֱٿ� ������ �ð��� �����´�.
		out.println("���� ��ȿ �ð�: " + session.getMaxInactiveInterval() + "<br>");
		// ���� ������ �������� �Ǻ��Ѵ�.
		if(session.isNew()) {
			out.print("�� ������ ����������ϴ�.");
		}
	}
}
