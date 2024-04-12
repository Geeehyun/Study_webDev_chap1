<%--
  Created by IntelliJ IDEA.
  User: wkdwl
  Date: 2024-04-12
  Time: 오전 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인 화면</title>
    <style>
        .info {
            color : red;
        }
    </style>
</head>
<body>
<form action="/member/login" method="post" id="frm" onsubmit="checkVal(this)">
    <table>
        <tr>
            <th>아이디</th>
            <td>
                <input type="text" id="user_id" name="user_id" value="${cookie.savedId.value}" maxlength="20">
            </td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td>
                <input type="password" id="pwd" name="pwd" value="" maxlength="20">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <label for="saved_id"><input type="checkbox" name="saved_id" id="saved_id" value="saved_id" <c:if test="${!empty cookie.savedId.value}">checked</c:if>>아이디저장</label>
                <label for="auto_login"><input type="checkbox" name="auto_login" id="auto_login" value="auto_login">자동로그인</label>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="info">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit" id="login">로그인</button>
                <button type="button" id="find_pwd">비밀번호 찾기</button>
                <button type="button" id="join">회원가입</button>
            </td>
        </tr>
    </table>
</form>
<script>
    if(${param.loginYN == "fail"}) {
        let info = document.createElement("span");
        info.innerText = "아이디와 비밀번호를 다시 확인해주세요";
        info.classList.add("info");
        document.querySelector(".info").append(info);
    }

    function checkVal(element) {
        event.preventDefault();
        let targets = ["user_id", "pwd"];
        document.querySelector("td.info").style.display = "none";
        for (let target of targets) {
            let el = document.querySelector("#" + target);
            let info2 = document.querySelector("#" + target + "+ .info");
            if (info2 != null ) el.parentNode.removeChild(info2);
            if (!el.value) {
                let info = document.createElement("span");
                info.innerText = "내용을 입력해주세요";
                info.classList.add("info");
                el.parentNode.append(info);
                el.focus();
                return false;
            } else if (!el.value.trim()) {
                let info = document.createElement("span");
                info.innerText = "내용을 입력해주세요";
                info.classList.add("info");
                el.parentNode.append(info);
                el.focus();
                return false;
            }

        }
        element.submit();
    }
</script>
</body>
</html>
