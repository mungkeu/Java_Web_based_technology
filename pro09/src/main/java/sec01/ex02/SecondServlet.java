package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	public void init(){
		System.out.println("init �޼��� ȣ��");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ù ��° �������� ������ �α��� ������ �����´�.
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		
		out.println("<html><body>");
		if(user_id!=null && user_id.length()!=0) {
			// ù ��° ������ ID ������ �̿��� �α��� ���¸� �����Ѵ�.
			out.println("�̹� �α��� �����Դϴ�!<br><br>");
			out.println("ù ��° �������� �Ѱ��� ���̵�: " + user_id + "<br>");
			out.println("ù ��° �������� �Ѱ��� ��й�ȣ: " + user_pw + "<br>");
			out.println("ù ��° �������� �Ѱ��� �ּ�: " + user_address + "<br>");
			out.println("</body></html>");
		}else {
			// �α���â�� ��ġ�� �ʰ� �ٷ� ��û�� ��쿡�� �α���â���� �ٽ� �̵��ϵ��� �ȳ��Ѵ�.
			out.println("�α��� ���� �ʾҽ��ϴ�.<br><br>");
			out.println("�ٽ� �α����ϼ���!!<br>");
			out.println("<a href='/pro09/login.html'>�α���â���� �̵��ϱ�</>");
		}
	}

	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}
}
