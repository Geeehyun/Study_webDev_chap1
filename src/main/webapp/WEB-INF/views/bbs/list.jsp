<%--
  Created by IntelliJ IDEA.
  User: wkdwl
  Date: 2024-04-04
  Time: 오전 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>리스트</title>
</head>
<body>
<h1>게시판 리스트</h1>
<ul>
<c:forEach var="bbsDto" items="${list}">
    <li><a href="/bbs/view?idx=${bbsDto.idx}">${bbsDto}</a></li>
</c:forEach>
</ul>
<br>
<button id="btn_regist" onclick="location.href='/bbs/regist'">글 등록</button>
<br>

<ul>
    <li><a href="/bbs/regist">등록</a></li>
    <li><a href="/bbs/view">상세</a></li>
    <li><a href="/bbs/modify">수정</a></li>
    <li><a href="/bbs/delete">삭제</a></li>
</ul>
</body>
</html>
