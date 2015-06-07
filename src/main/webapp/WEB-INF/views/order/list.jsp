<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
<table width="700" align="center" border="1">
	<tr>
	<td>用户标识:${pagers.total }</td><td>用户名</td><td>用户昵称</td><td>用户密码</td><td>用户邮箱</td>
	<td>操作</td>
	</tr>

    <c:forEach items="${orders }" var="u">
    <tr>
    <td>${u.id }</td><td>${u.username }</td>
    <td><a href="${u.id }">${u.nickname }</a></td>
    <td>${u.password }</td><td>${u.email }</td>
    <td><a href="${u.id }/update">更新</a>&nbsp;<a href="${u.id }/delete">删除</a></td>
    </tr>
    </c:forEach>

</table>
</body>
</html>