<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/4/11
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>user</title>
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
    <%--<%--%>
        <%--List<User> users = (List<User>)request.getAttribute("users");--%>
        <%--for (User user:users) {--%>
    <%--%>--%>
    <%--<tr>--%>
        <%--<td>--%>
            <%--<%=user.getId()%>--%>
        <%--</td>--%>
        <%--<td>--%>
            <%--<%=user.getUsername()%>java--%>
        <%--</td>--%>
        <%--<td>--%>
            <%--<%=user.getPassword()%>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.sex}</td>
                <td>${user.age}</td>
                <td>
                    <a title="修改" href="<%=request.getContextPath()%>/UserServlet?action=queryOne&id=${user.id}">
                        修改
                    </a>
                    <a title="删除" href="<%=request.getContextPath()%>/UserServlet?action=delete&id=${user.id}">
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
        <a href="/UserServlet?action=queryPage&pageIndex=${i}">
                ${i}
        </a>
    </c:forEach>
</div>
</body>
</html>
