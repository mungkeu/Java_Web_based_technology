<%@page import="java.util.List"%>
<%@page import="sec01.ex01.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 유즈빈에 속성 값을 설정하기 전에 한글 인코딩 작업 수행
	request.setCharacterEncoding("UTF-8");
%>
<!-- 유즈빈 액션 태그로 id가 m인 MemberBean 객체 생성 -->
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	/*자바 코드에서 MemberBean 객체를 생성하지 않는다.
	MemberBean m = new MemberBean(id, pwd, name, email); */
	m.setId(id);
	m.setPwd(pwd);
	m.setName(name);
	m.setEmail(email);
	
	MemberDAO memberDAO = new MemberDAO();
	// 회원 정볼르 추가한 후 목록으로 출력
	memberDAO.addMember(m);
	List membersList = memberDAO.listMembers();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
			<td width="5%">가입일</td>
		</tr>
	<%
		if(membersList.size()==0){
	%>
		<tr>
			<td colspan="5">
				<p align="center"><b>
				<span style="font-size:9pt;">등록된 회원이 없습니다.</span>
				</b></p>
			</td>
		</tr>
		<%
		}else{
			for(int i=0; i<membersList.size(); i++)
			{
				MemberBean bean = (MemberBean) membersList.get(i);
		%>
		<tr align="center">
			<td>
				<%=bean.getId() %>
			</td>
			<td>
				<%=bean.getPwd() %>
			</td>
			<td>
				<%=bean.getName() %>
			</td>
			<td>
				<%=bean.getEmail() %>
			</td>
			<td>
				<%=bean.getJoinDate() %>
			</td>
		</tr>
		<%
			}
		}
		%>
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>
</body>
</html>