<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/4/11
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<center>
    <fieldset style="width: 300px;">
        <legend>
            <br>修改
        </legend>
        <form action="UserServlet?action=update&id=${userById.id}" method="post">
            <table>
                <tr>
                    <td>
                        姓名:
                    </td>
                    <td>
                        <input type="text" name="name" value="${userById.name}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                       性别:
                    </td>
                    <td>
                        <input type="test" name="sex" value="${userById.sex}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        年龄:
                    </td>
                    <td>
                        <input type="number" name="age" value="${userById.age}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="修改" />
                    </td>
                    <td>
                        <input type="reset" value="重置" />
                    </td>
                </tr>
            </table>
        </form>
    </fieldset>
</center>
</body>
</html>
</body>
</html>
