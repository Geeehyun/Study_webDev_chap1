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
    <title>게시글 수정</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<h1>게시글 수정</h1>
<div>
    <form id="frmModify" name="frmModify" method="post" action="/bbs/modify" onsubmit="checkVal(this)">
        <input type="hidden" id="user_id" name="user_id" value="test">
        <input type="hidden" id="idx" name="idx" value="${view.idx}">
        <table>
            <tr>
                <td><span>제목 : </span></td>
                <td>
                    <input type="text" name="title" id="title" value="${view.title}" maxlength="200" placeholder="글 제목을 입력해주세요">
                    <c:if test="${!empty titleNull}">
                        <br><span style="color: red">제목을 입력해주세요</span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td><span>등록일 :</span></td>
                <td>
                    <input type="date" name="display_date" id="display_date" value="${view.display_date}">
                    <c:if test="${!empty display_dateNull}">
                        <br><span style="color: red">등록일을 입력해주세요</span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td><span>내용 : </span></td>
                <td>
                    <textarea name="content" id="content" rows="10" cols="80">${view.content}</textarea>
                    <c:if test="${!empty contentNull}">
                        <br><span style="color: red">내용을 입력해주세요</span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">수정</button>
                    <button type="button" onclick="location.href = '/bbs/view?idx=1'">취소</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    function checkVal(frm) {
        event.preventDefault();
        let target = ["title", "content", "display_date"];
        for(let e of target) {
            removeWarn(e)
        }
        for (let e of target) {
            let element = document.querySelector("#"+e);
            let eVal =  document.querySelector("#"+e).value;
             if (!element.value) {
                 addWarn(e, e + "를 입력해주세요")
                 element.focus();
                 return false;
             } else if (!eVal.trim()) {
                 addWarn(e, e + "를 입력해주세요")
                 element.focus();
                 return false;
             }
             if (e == "display_date") {
                 let today = new Date();
                 let targetDay = new Date(eVal);
                 if (today.getTime() < targetDay.getTime()) {
                     addWarn(e, e + "은 오늘보다 미래일 수 없습니다.")
                     element.focus();
                     return false;
                 }
             }
            removeWarn(e);
        }
        frm.submit();
    }

    function addWarn(element, txt) {
        let target = document.querySelector("#" + element + "+ span");
        if (target == null) {
            let warn = document.createElement("span");
            warn.innerText = txt;
            warn.style.color = "red";
            warn.classList.add("warn");
            document.querySelector("#" + element).parentNode.append(warn);
        }
    }
    function removeWarn(element) {
        let target = document.querySelector("#" + element + "+ span");
        if (target != null) {
            let parent = target.parentNode;
            parent.removeChild(target);
        }
    }
</script>
</body>
</html>
