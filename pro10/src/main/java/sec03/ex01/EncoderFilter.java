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


// WebFilter 애너테이션을 이용해 모든 요청이 필터를 거치게 한다.
@WebFilter("/*")   // 사용자 정의 필터는 반드시 Filter 인터페이스를 구현해야 한다.
public class EncoderFilter extends HttpFilter implements Filter {

	ServletContext context;
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 인코딩...........");
		context = fConfig.getServletContext();
	}
	
	// doFilter() 안에서 실제 필터 기능을 구현한다.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		System.out.println("doFilter 호출");
		
		// 한글 인코딩 설정 작업을 한다.
		request.setCharacterEncoding("utf-8");
		
		// getContextPath()로 웹 애플리케이션의 컨텍스트 이름을 가져온다.
		String context = ((HttpServletRequest)request).getContextPath();
		// getRequestURI()로 웹 애플리케이션의 컨텍스트 이름을 가져온다.
		String pathinfo = ((HttpServletRequest)request).getRequestURI();
		// getRealPath(pathinfo)로 요청 URI의 셀제 경로를 가져온다.
		String realPath = request.getRealPath(pathinfo);
		String mesg = "Context 정보:" + context
					   + "\nURI 정보:" + pathinfo
					   + "\n물리적 경로:" + realPath;
		System.out.println(mesg);
		
		// 요청 필터에서 요청 처리 전의 시각을 구한다.
		long begin = System.currentTimeMillis();
		chain.doFilter(request, response); // 다음 필터로 넘기는 작업을 수행한다.
		
		// 요청 필터에서 요청 처리 후의 시각을 구한다.
		long end = System.currentTimeMillis();
		System.out.println("작업 시간:" + (end-begin)+"ms");
	}

	public void destroy() {
		System.out.println("destroy 호출");
	}
}
