<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	body
	{
		background-image: url("resource/background4.gif");
		background-repeat: no-repeat;
		background-size: cover;
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

		<h1 style="color: white" class="my-5">메인 페이지</h1>

<h1><span class="blue">&lt;</span>Table<span class="blue">&gt;</span> <span class="yellow">Responsive</pan></h1>
<h2>Created with love by <a href="https://github.com/pablorgarcia" target="_blank">Pablo García</a></h2>

<div style="height: 600px;overflow-y: auto;">
<table class="container">
	<thead>
		<tr>
			<th><h1>이름</h1></th>
			<th><h1>전화번호</h1></th>
			<th><h1>주소</h1></th>
			<th><h1>성별</h1></th>
			<th><h1>수정</h1></th>
			<th><h1>삭제</h1></th>
		</tr>
	</thead>
	<%-- <c:forEach items="" var="" step="" >
	</c:forEach> --%>
	<tbody>
		<tr>
			<td>Google</td>
			<td>9518</td>
			<td>6369</td>
			<td>01:32:50</td>
			<td><button class="transparent_button" onclick="moveedit()"><img src="resource/edit.png" alt="" width="30"></button></td>
			<td><button class="transparent_button" onclick="movedelete()"><img src="resource/delete.png" alt="" width="30"></button></td>
		</tr>
		<tr>
			<td>Twitter</td>
			<td>7326</td>
			<td>10437</td>
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
		</tr>
	</tbody>
</table>
</div>
</body>
</html>