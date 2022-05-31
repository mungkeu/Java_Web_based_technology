package sec01.ex01;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	// 데이터베이스 연결을 위한 계정 및 드라이버 정보저장
	private static final String driver = "oracle.jdbc.driver.OracleDriver"; 
	private static final String url = "jdbc:oracle:thin:@localhost:1521:study";
	private static final String user = "scott";
	private static final String pwd = "asdf";
	//
	private Statement stmt;
	private Connection con;
	
	public List<MemberVO> listMembers()
	{
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			connDB(); // 데이터베이스 연결을 수행하는 메서드
			String query = "select * from t_member"; // SQL문 작성
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query); // 작성한 SQL문으로 회원 정보를 조회
			while(rs.next())
			{
				// 조회한 레코드의 각 컬럼 값을 받아온다.
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				// 각 컬럼 값을 다시 MemverVO 객체의 속성에 설정한다.
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			
			// 수행후 열린 커넥션들을 닫아준다.
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list; // 조회한 레코드의 개수만큼 MemberVO 객체를 저장한 ArrayList를 반환
	}
	
	// 데이터베이스 연결을 수행하는 메서드
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con=DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			stmt=con.createStatement();
			System.out.println("Statement 생성 성공");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
