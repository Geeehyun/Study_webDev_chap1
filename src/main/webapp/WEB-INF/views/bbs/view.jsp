<%--
  Created by IntelliJ IDEA.
  User: wkdwl
  Date: 2024-04-04
  Time: 오전 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
    <title>게시판 상세</title>
</head>
<body>
<h1>게시글 상세</h1>

<div>${dto.idx}</div>
<div>${dto.user_id}</div>
<div>${dto.title}</div>
<div>${dto.content}</div>
<div>${dto.display_date}</div>
<div>${dto.readCnt}</div>
<div>
    <button type="button" onclick="location.href = '/bbs/list'">리스트</button>
    <button type="button" onclick="location.href = '/bbs/modify?idx=1'">수정</button>
    <button type="button" onclick="deleteThis()">삭제</button>
</div>
<script>
    function deleteThis() {
        let frmEl = document.createElement('form');
        let idEl = document.createElement('input');

        idEl.setAttribute('type', 'hidden');
        idEl.setAttribute('name', 'idx');
        idEl.setAttribute('value', '1');
        frmEl.appendChild(idEl);
        frmEl.setAttribute('action', '/bbs/delete');
        frmEl.setAttribute('method', 'post');
        frmEl.setAttribute('id', 'frm');
        document.body.appendChild(frmEl);
        document.querySelector('#frm').submit();
    }
</script>
</body>
</html>
