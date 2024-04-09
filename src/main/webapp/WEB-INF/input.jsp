<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calc" method="post" id="frmCalc">
    <input type="text" name="num1"><br>
    <input type="text" name="num2"><br>
    <%
        String err = "";
        err = (request.getAttribute("errCode") != null) ?  (String) request.getAttribute("errCode") : "";

        String result = "";
        result = (request.getAttribute("result") != null) ?  (String) request.getAttribute("result") : "";

        if (!err.equals("")) {
            out.println("<div><span>오류입니다.</span></div>");
        } else if(!result.equals("")) {
            out.println("<div><span>" + result + "</span></div>");
        }
    %>
    <button type="submit">END</button>
</form>
</body>
</html>
