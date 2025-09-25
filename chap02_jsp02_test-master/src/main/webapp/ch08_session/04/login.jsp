<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!-- 로그인폼을 먼저 실행해야지, 이거부터 실행하면 에러남, 
왜냐하면 로그인폼에서 데이타 받아서 처리하는 명령문이라서 그렇다-->
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

if (id.equals("java") && password.equals("1234")) {
   // 세션 객체 생성
   HttpSession ses = request.getSession(false);
   // 세션 객체에 userId 저장
   ses.setAttribute("userId", id);
   // welcome.jsp 페이지로 이동
   response.sendRedirect("welcome.jsp");
} else { // 로그인 실패
   // 로그인 실패시 html 경고 메시지 출력 및 뒤로가기 페이지 렌더링
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
   <p>아이디와 비밀번호를 확인하세요.</p>
   <a href="loginForm.jsp">로그인</a>
</body>
</html>
<%
} // end of else
%>
