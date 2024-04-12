<%--
  Created by IntelliJ IDEA.
  User: wkdwl
  Date: 2024-04-04
  Time: 오전 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>게시글 등록</title>
</head>
<body>
<h1>게시글 등록</h1>
<div>
    <form id="frmRegist" name="frmRegist" method="post" action="/bbs/regist">
        <input type="hidden" name="user_id" id="user_id" value="test">
        <table>
            <tr>
                <td><span>제목 : </span></td>
                <td>
                    <input type="text" name="title" id="title" value="${title}" maxlength="200" placeholder="글 제목을 입력해주세요">
                    <c:if test="${!empty titleNull}">
                        <br><span style="color: red">제목을 입력해주세요</span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td><span>등록일 :</span></td>
                <td>
                    <input type="date" name="display_date" id="display_date" value="${display_date}">
                    <c:if test="${!empty display_dateNull}">
                        <br><span style="color: red">등록일을 입력해주세요</span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td><span>내용 : </span></td>
                <td>
                    <textarea name="content" id="content" rows="10" cols="80">${content}</textarea>
                    <c:if test="${!empty contentNull}">
                        <br><span style="color: red">내용을 입력해주세요</span>
                    </c:if>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <td><span>취미 : </span></td>--%>
<%--                <td>--%>
<%--                    <input <c:if test="${fn:contains(hobbies, '여행')}">checked</c:if> type="checkbox" name="hobbies" id="hobbies_0" value="여행"> 여행--%>
<%--                    <input <c:if test="${fn:contains(hobbies, '독서')}">checked</c:if> type="checkbox" name="hobbies" id="hobbies_1" value="독서"> 독서--%>
<%--                    <input <c:if test="${fn:contains(hobbies, '수영')}">checked</c:if> type="checkbox" name="hobbies" id="hobbies_2" value="수영"> 수영--%>
<%--                    <input <c:if test="${fn:contains(hobbies, '잠자기')}">checked</c:if> type="checkbox" name="hobbies" id="hobbies_3" value="잠자기"> 잠자기--%>
<%--                    <input <c:if test="${fn:contains(hobbies, '게임')}">checked</c:if> type="checkbox" name="hobbies" id="hobbies_4" value="게임"> 게임--%>
<%--                    <c:if test="${!empty hobbiesNull}">--%>
<%--                        <br><span style="color: red">취미를 선택해주세요</span>--%>
<%--                    </c:if>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td><span>성별 : </span></td>--%>
<%--                <td>--%>
<%--                    <input <c:if test="${gender == '남'}">checked</c:if> type="radio" name="gender" id="gender_0" value="남"> 남자--%>
<%--                    <input <c:if test="${gender == '여'}">checked</c:if> type="radio" name="gender" id="gender_1" value="여"> 여자--%>
<%--                    <c:if test="${!empty genderNull}">--%>
<%--                        <br><span style="color: red">성별을 선택해주세요</span>--%>
<%--                    </c:if>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <td colspan="2">
                    <button type="submit">등록</button>
                    <button type="reset">취소</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
