<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
	<link rel="stylesheet" href="">
</head>
<body>
<h2>FM</h2>
<table border="solid">	
	<tr>
		<td>序号</td>
		<td>名字</td>
		<td>天数</td>
		<td>操作</td>
	</tr>	
	<c:forEach items="${staffTravel}" var="s" varStatus="status">	
		<tr>
			<td>${status.index+1}</td>
			<td>${s.staffName}</td>
			<td>${s.travel}</td>
			<td><a href="${APP_PATH}/financialManager/agree?tra_id=${s.id}">同意</a>&nbsp;<a href="${APP_PATH}/financialManager/refuse?tra_id=${s.id}">拒绝</a></td>
		</tr>
	</c:forEach>
</table>


</body>
</html>