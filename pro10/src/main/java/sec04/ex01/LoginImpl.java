package sec04.ex01;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoginImpl implements HttpSessionListener {
	String user_id;
	String user_pw;
	static int total_user=0;
	
    public LoginImpl() {
        
    }

    public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
    
    // 세션 생성 시 이벤트를 처리한다.
    @Override
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("세션 생성");
		++total_user; // 세션 생성 시 접속자수를 1 증가시킨다.
    }

    // 세션 소멸 시 이벤트를 처리한다.
    @Override
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("세션 소멸");
		total_user--; // 세션 소멸 시 접속자수를 1 감소시킨다.
    }
}
