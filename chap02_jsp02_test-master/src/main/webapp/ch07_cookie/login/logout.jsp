<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    
    Cookie[] cookies = request.getCookies();
    
    
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            
            if (cookies[i].getName().equals("userName")) {
            
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
            }
        }
    }

    // 로그아웃 후 리디렉션할 페이지를 설정합니다. 예: 로그인 페이지
    String redirectURL = "login.jsp";
    response.sendRedirect(redirectURL);
%>
