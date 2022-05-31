package sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


// WebFilter �ֳ����̼��� �̿��� ��� ��û�� ���͸� ��ġ�� �Ѵ�.
@WebFilter("/*")   // ����� ���� ���ʹ� �ݵ�� Filter �������̽��� �����ؾ� �Ѵ�.
public class EncoderFilter extends HttpFilter implements Filter {

	ServletContext context;
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 ���ڵ�...........");
		context = fConfig.getServletContext();
	}
	
	// doFilter() �ȿ��� ���� ���� ����� �����Ѵ�.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		System.out.println("doFilter ȣ��");
		
		// �ѱ� ���ڵ� ���� �۾��� �Ѵ�.
		request.setCharacterEncoding("utf-8");
		
		// getContextPath()�� �� ���ø����̼��� ���ؽ�Ʈ �̸��� �����´�.
		String context = ((HttpServletRequest)request).getContextPath();
		// getRequestURI()�� �� ���ø����̼��� ���ؽ�Ʈ �̸��� �����´�.
		String pathinfo = ((HttpServletRequest)request).getRequestURI();
		// getRealPath(pathinfo)�� ��û URI�� ���� ��θ� �����´�.
		String realPath = request.getRealPath(pathinfo);
		String mesg = "Context ����:" + context
					   + "\nURI ����:" + pathinfo
					   + "\n������ ���:" + realPath;
		System.out.println(mesg);
		
		// ��û ���Ϳ��� ��û ó�� ���� �ð��� ���Ѵ�.
		long begin = System.currentTimeMillis();
		chain.doFilter(request, response); // ���� ���ͷ� �ѱ�� �۾��� �����Ѵ�.
		
		// ��û ���Ϳ��� ��û ó�� ���� �ð��� ���Ѵ�.
		long end = System.currentTimeMillis();
		System.out.println("�۾� �ð�:" + (end-begin)+"ms");
	}

	public void destroy() {
		System.out.println("destroy ȣ��");
	}
}
