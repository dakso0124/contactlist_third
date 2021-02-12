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
function moveedit()
{
	location.href = "admin.jsp";
}

function movedelete()
{
	location.href = "admin.jsp";
}
</script>


</head>
<body class="text-center">

<header>
<form action="ModifyServlet">
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

<h1><span class="blue">&lt;</span>${name }님<span class="blue">&gt;</span> <span class="yellow">안녕하세요 :D</pan></h1>
<h2>Edit by <a href="https://github.com/dakso0124" target="_blank">Dakso</a></h2>

<div style="height: 600px;overflow-y: auto;">
<table class="container">
	<thead>
		<tr>
			<th><h1>이름</h1></th>
			<th><h1>전화번호</h1></th>
			<th><h1>주소</h1></th>
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
				<td>${contact.address }</td>
				<td>${contact.relation_name }</td>
				<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
				<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
			</tr>
		</c:forEach>
		<!-- <tr>
			<td>정재겸</td>
			<td>010-2470-2307</td>
			<td>경기도 성남시 수정구 복정동 702-10 202호 </td>
			<td>남</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr>
		<tr>
			<td>마이꼬르</td>
			<td>010-2477-2123</td>
			<td>서울시 어디고 어디쯤 어딘가~~~~~~~~~~~~~~~~~~~~~~~</td>
			<td>00:51:22</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr>
		<tr>
			<td>Amazon</td>
			<td>4162</td>
			<td>5327</td>
			<td>00:24:34</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr>
    <tr>
			<td>LinkedIn</td>
			<td>3654</td>
			<td>2961</td>
			<td>00:12:10</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr>
    <tr>
			<td>CodePen</td>
			<td>2002</td>
			<td>4135</td>
			<td>00:46:19</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr>
    <tr>
			<td>GitHub</td>
			<td>4623</td>
			<td>3486</td>
			<td>00:31:52</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr>
		<tr>
			<td>GitHub</td>
			<td>4623</td>
			<td>3486</td>
			<td>00:31:52</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr>
		<tr>
			<td>GitHub</td>
			<td>4623</td>
			<td>3486</td>
			<td>00:31:52</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr>
		<tr>
			<td>GitHub</td>
			<td>4623</td>
			<td>3486</td>
			<td>00:31:52</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr>
		<tr>
			<td>GitHub</td>
			<td>4623</td>
			<td>3486</td>
			<td>00:31:52</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr>
		<tr>
			<td>GitHub</td>
			<td>4623</td>
			<td>3486</td>
			<td>00:31:52</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr> -->
	</tbody>
</table>
</div>
</body>
</html>