<%--
  Created by IntelliJ IDEA.
  User: wkdwl
  Date: 2024-04-12
  Time: 오전 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <div style="background-color: #555; margin: 0; padding: 10px; display: flex;align-items: center;justify-content: space-between;">
        <c:choose>
            <c:when test="${empty sessionScope.user_id}">
                <button type="button" id="btnLogin" onclick="location.href = '/member/login'" >login</button>
                <button type="button" id="btnJoin" onclick="alert('미개발')" >join</button>
                <script>
                    if (${!empty cookie.autoLogin.value}) {
                        let frm = document.createElement("form");
                        frm.action = "/member/autoLogin";
                        frm.method = "post";
                        frm.id = "frm";
                        document.body.append(frm);

                        let input = document.createElement("input");
                        input.value = "${cookie.autoLogin.value}"
                        input.name = "user_id";
                        document.querySelector("#frm").append(input);

                        document.querySelector("#frm").submit();
                    }
                </script>
            </c:when>
            <c:otherwise>
                <p style="color: #fff"><span style="font-weight: 800; text-decoration: underline;">${sessionScope.name}</span>님 환영합니다.</p>
                <button type="button" id="btnLogout" onclick="logout()">logout</button>
                <script>
                    function logout() {
                        let frm = document.createElement("form");
                        frm.action = "/member/logout";
                        frm.method = "post";
                        frm.id = "frm";
                        document.body.append(frm);
                        document.querySelector("#frm").submit();
                    }
                </script>
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>
