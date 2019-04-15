<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/4/12
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>student</title>
</head>
<body>
<table>
    <%-- 表头 --%>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <%--数据--%>
    <c:forEach items="${sList}" var="sl">
        <tr>
            <td>${sl.id}</td>
            <td>${sl.name}</td>
            <td>${sl.sex}</td>
            <td>${sl.age}</td>
            <td>
                <a title="修改" href="<%=request.getContextPath()%>/StudentServlet?action=queryOne&id=${sl.id}">
                    修改
                </a>
                <a title="删除" href="<%=request.getContextPath()%>/StudentServlet?action=delete&id=${sl.id}">
                    删除
                </a>
                <a title="添加" href="/add.jsp">
                    添加
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<%-- 分页页码  --%>
<div>
    <c:forEach var="i" begin="1" end="${pages}" >
        <a href="/StudentServlet?action=queryPage&pageIndex=${i}">
                ${i}
        </a>
    </c:forEach>
</div>
</body>
</html>
