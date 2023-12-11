<%--
  Created by IntelliJ IDEA.
  User: chiuchiuleuleu
  Date: 11/12/2023
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="number" name="id" value="${studentEdit.id}" placeholder="id">
    <br>
    <input type="text" name="name" value="${studentEdit.name}" placeholder="name">
    <br>
    <input type="number" name="age" value="${studentEdit.age}" placeholder="age">
    <br>
    <input type="text" name="sex" value="${studentEdit.sex}" placeholder="Sex">
    <br>
    <input type="text" name="address" value="${studentEdit.address}" placeholder="address">
    <br>
    <input type="number" name="averageScore" value="${studentEdit.averageScore}" placeholder="Average Score">
    <br>
    <button>Sửa</button>
</form>
</body>
</html>
