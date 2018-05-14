<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<form action="/admin/permission_Add" method="get">
			名称： <input type="text" name="pname" /> <br /> 
			路径： <input type="text" name="paddr" /><br /> 
			是否生成菜单：
			<select name="state">
				<option value="1">生成</option>
				<option value="0">不生成</option>
			</select><br />
			 父功能点：
			<select name="pid">
				<c:forEach items="${permissionList }" var="p">
					<option value="${p.id}">${ p.pname}</option>
				</c:forEach>
			</select><br/>
			<input type="submit" name="" value="添加" />
		</form>

	</body>

</html>