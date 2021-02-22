<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
		padding-top: 10px;
  		padding-right: 10px;
	}
	.centered
	{
		text-align: left;
		overflow: hidden;
		width: 80%;
		margin: 0 auto;
		display: table;
	  	padding: 0 0 1em 0;
	  	max-width: 1320px;
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
	
	function search()
	{
		// Declare variables
		var input, filter, table, tr, td, i, nameValue;
		input = document.getElementById("search");
		filter = input.value.toUpperCase();
		table = document.getElementById("contactTable");
		tr = table.getElementsByTagName("tr");
		
		// Loop through all table rows, and hide those who don't match the search query
		for (i = 0; i < tr.length; i++)
		{
			td = tr[i].getElementsByTagName("td")[0];
			
			if (td)
			{
				nameValue = td.textContent || td.innerText;
				
				if (nameValue.toUpperCase().indexOf(filter) > -1 )
				{
			    	tr[i].style.display = "";
				}
				else
				{
			    	tr[i].style.display = "none";
			  	}
			}
		}
	}
	
	//alert
	<c:if test="${msg ne null }">
		<c:set var="msg" value="${msg}"/>
		
		<c:if test="${fn:contains(msg, 'timeout')}">
			alert('세션 만료');
		</c:if>
		
		<c:if test="${fn:contains(msg, 'fail')}">
			alert('연락처 삭제에 실패했습니다.');
		</c:if>
	</c:if>
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

<div style="height: 600px; overflow-y: auto;">

<c:if test="${not empty list}">					<!-- 연락처 리스트 갯수에 따라 filter 적용	 -->
	<c:set var="slist" value="${list}"/>
	<c:set var="size" value="${fn:length(slist)}"/>
	<c:if test="${size > 1 }">
		<div class="centered" style="margin-bottom: 1em;">
			<input type="text" class="form-control" id="search" placeholder="검색할 이름을 입력하세요.." onkeyup="search()" size="10" required>
		</div>
	</c:if>
</c:if>
	<table class="container" id="contactTable">
		<thead>
			<tr>
				<th style="width:15%"><h1>이름</h1></th>
				<th style="width:15%"><h1>전화번호</h1></th>
				<th style="width:35%"><h1>메모</h1></th>
				<th style="width:15%"><h1>그룹</h1></th>
				<th style="width:10%"><h1>수정</h1></th>
				<th style="width:10%"><h1>삭제</h1></th>
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