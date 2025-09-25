<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
       // 전송 파라미터 얻기
       //String id = request.getParameter("id");
    
       // 쿠키 읽어서 userName 되어 있는 쿠키 찾고 그 쿠키의 이름을 가지고 온다.
       // request에서 쿠키 얻어내기
       Cookie[] cookies = request.getCookies();
       String userName = "손님";
       
       if(cookies != null){
          for(Cookie cookie: cookies){
             if(cookie.getName().equals("userName")){
                userName = URLDecoder.decode(cookie.getValue(), "utf-8");
                break; // 반복문 탈출
             }
          }
       }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome.jsp</title>
</head>
<body>
   <h3>환영합니다. <%= userName %></h3>
</body>
</html>