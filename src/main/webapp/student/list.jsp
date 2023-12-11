<%--
  Created by IntelliJ IDEA.
  User: chiuchiuleuleu
  Date: 11/12/2023
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sinh viên</h1>
<a href="/student?action=create">Tạo mới</a>
<table class="table table-striped" style="border: solid 1px lightgray">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Sex</th>
        <th>Address</th>
        <th>Average Score</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${studentList}' var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.sex}</td>
            <td>${student.address}</td>
            <td>${student.averageScore}</td>
                <td><a href="/student?action=edit&id=${student.id}">Sửa</a></td>
                <td><a href="/student?action=delete&id=${student.id}">Xóa</a></td>
        </tr>
    </c:forEach>
    </tbody>
    <a href="/student?action=sortByAverageScore">Sắp xếp theo điểm trung bình</a>
</table>
</body>
</html>
