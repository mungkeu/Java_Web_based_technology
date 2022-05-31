package sec01.ex01;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	// �����ͺ��̽� ������ ���� ���� �� ����̹� ��������
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
			connDB(); // �����ͺ��̽� ������ �����ϴ� �޼���
			String query = "select * from t_member"; // SQL�� �ۼ�
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query); // �ۼ��� SQL������ ȸ�� ������ ��ȸ
			while(rs.next())
			{
				// ��ȸ�� ���ڵ��� �� �÷� ���� �޾ƿ´�.
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				// �� �÷� ���� �ٽ� MemverVO ��ü�� �Ӽ��� �����Ѵ�.
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			
			// ������ ���� Ŀ�ؼǵ��� �ݾ��ش�.
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list; // ��ȸ�� ���ڵ��� ������ŭ MemberVO ��ü�� ������ ArrayList�� ��ȯ
	}
	
	// �����ͺ��̽� ������ �����ϴ� �޼���
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle ����̹� �ε� ����");
			con=DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection ���� ����");
			stmt=con.createStatement();
			System.out.println("Statement ���� ����");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
