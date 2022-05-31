package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member2")
public class MemberServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {

	}

	public void destroy() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO(); // SQL������ ��ȸ�� MemberDAO ��ü ����
		List<MemberVO> list = dao.listMembers(); // listMembers() �޼���� ȸ�� ������ ��ȸ
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td>"
				+ "<td>�̸���</td><td>������</td></tr>");
		
		// ��ȸ�� ȸ�� ������ for���� <tr> �±׸� �̿��� ����Ʈ�� ���.
		for(int i=0; i<list.size(); i++)
		{
			MemberVO memberVO = list.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" 
			+ name +"</td><td>" + email + "</td><td>" + joinDate + "</td></tr>");
		}
		
		out.print("</table></body></html>");
	}

}
