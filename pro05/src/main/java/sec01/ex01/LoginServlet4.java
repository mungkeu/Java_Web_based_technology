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
		System.out.println("init �޼��� ȣ��");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("doget �޼��� ȣ��");
		doHandle(request, response); // GET ������� ��û �� �ٽ� doHandle()�� ȣ���Ѵ�.
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("doPost �޼��� ȣ��");
		doHandle(request, response); // Post ������� ��û �� �ٽ� doHandle()�� ȣ���Ѵ�.
	}
	
	// ��� ȣ�� ��Ŀ� ���ؼ� ó���� �� �ִ�.
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		System.out.println("doHandle �޼��� ȣ��");
		String user_pw = request.getParameter("user_pw");
		System.out.println("���̵�:" + user_id);
		System.out.println("��й�ȣ:" + user_pw);
	}
	
	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}
}
