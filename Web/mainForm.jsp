<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>

<style>
	body
	{
		background-image: url("resource/background4.gif");
		background-repeat: no-repeat;
		background-size: cover;
	}
	header
	{
		display : flex;
		justify-content: flex-end;
		/* display:inline-block; */
	}
</style>

<link href="bootstrap-5.0/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap-5.0/mainForm.css" rel="stylesheet">
<script>
function moveedit(id)
{
	location.href = "ModifyContactServlet?contactid=" + id;
}

function movedelete(id)
{
	location.href = "DeleteContactServlet?contactid=" + id;
}
</script>


</head>
<body class="text-center">

<header>
<form action="ModifyUserServlet">
	<div>
		<button class="w-100 btn btn-md btn-primary" type="submit">정보수정</button>
	</div>
</form>
<form action="LogoutServlet">
	<div>
		<button class="w-100 btn btn-md btn-primary" type="submit">로그아웃</button>
	</div>
</form>
</header>

<h1 style="color: #81F5D8" class="my-5">연락처 목록</h1>
<form action="InsertContactServlet">
<h1><span class="blue">&lt;</span>${name }님<span class="blue">&gt;</span> <span class="yellow">안녕하세요 :D</span>

<span class="col-sm-3"><button class="w-40 h-50 btn btn-md btn-primary" type="submit">연락처 추가</button></span>
</h1></form>
<h2>Edit by <a href="https://github.com/dakso0124" target="_blank">Dakso</a></h2>



<div style="height: 600px;overflow-y: auto;">
<table class="container">
	<thead>
		<tr>
			<th><h1>이름</h1></th>
			<th><h1>전화번호</h1></th>
			<th><h1>메모</h1></th>
			<th><h1>그룹</h1></th>
			<th><h1>수정</h1></th>
			<th><h1>삭제</h1></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="contact" >
			<tr>
				<td>${contact.name }</td>
				<td>${contact.phone }</td>
				<td>${contact.memo }</td>
				<td>${contact.relation_name }</td>
				<td><button class="transparent_button" onclick="moveedit(${contact.contactID })"><img src="resource/edit.png" alt="" width="30"></button></td>
				<td><button class="transparent_button" onclick="movedelete(${contact.contactID })"><img src="resource/delete.png" alt="" width="30"></button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>