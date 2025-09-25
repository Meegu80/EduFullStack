<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 세션(Session)이란?
    // 클라이언트가 톰캣 웹 어플리케이션 서버(WAS)에 접속하면 톰캣은 JSESSIONID를
    // 발급해서 쿠키로 사용자에게 내려보낸다. JSESSIONID의 값은 클라이언트를
    // 구분하는 식별자 역할을 한다.
    // 클라이언트는 이후부터 서버에 접속할 때 항상 JSESSIONID를 톰캣에게 제공한다.
    // 클라이언트가 로그인을 한 후에 사용자 정보를 세션에 저장하면 해당 클라이언트의
    // 락커룸 역할을 하는 세션에 저장된다.
    // 세션 객체 가져오기
    HttpSession ses = request.getSession();
    
    // 세션 ID 조회
    String sessionId = ses.getId(); // JSESSIONID
    
    // 세션에 마지막 접근 시간 조회
    long lastAccessedTime = ses.getLastAccessedTime();
    
    // 시간 변환
    java.util.Date lastDate = new java.util.Date(lastAccessedTime);    
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>sessionInfo.jsp</title>
</head>
<body>
    <h3>세션 정보 확인하기</h3>
   
    <p>세션 ID : <%= sessionId %></p>
    <p>마지막 접근 시간 : <%= lastDate %></p>
</body>
</html>
