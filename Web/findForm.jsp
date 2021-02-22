<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ID · PW 찾기 페이지</title>
	<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">

	<link href="bootstrap-5.0/css/bootstrap.min.css" rel="stylesheet">
	 	<style>
	 		body
	 		{
	 			background-image: url("resource/background2.gif");
	 			background-repeat:inherit;
	 			background-size: ;
	 		}
	 		
			.bd-placeholder-img
			{
				font-size: 1.125rem;
				text-anchor: middle;
				-webkit-user-select: none;
				-moz-user-select: none;
				user-select: none;
			}
	
		    @media (min-width: 768px)
			{
				.bd-placeholder-img-lg
				{
		          font-size: 3.5rem;
		        }
		    }
		    h1
			{
			  background: -webkit-linear-gradient(#FFC300, #F79423);
			  -webkit-background-clip: text;
			  -webkit-text-fill-color: transparent;
			}
			label
			{
				color: white;
			}
			.main_container
			{
				width:100%;
				height:100%;
			}
			.main_title
			{
				width:100%;
				height:30%;
				float:left;
			}
			.main_left
			{
				width:50%;
				height:60%;
				float:left;
			}
			.main_right
			{
				width:50%;
				height:60%;
				float:left;
			}
			.main_list
			{
				width:100%;
				height:10%;
				float:left;
			}
			.main_center_sort
			{
				width: 50%;
				height: 70%;
				margin: 10% auto 10%; --> div 가운데 정열
				text-align:center; --> div 안쪽 텍스트 가운데 정렬
				background-repeat: no-repeat;
			}
	    </style>
    <link href="bootstrap-5.0/sign-in/signin.css" rel="stylesheet">
    
    <script type="text/javascript">
  	//alert
    <c:if test="${msg ne null }">
    	<c:set var="msg" value="${msg}"/>
    	
    	<c:if test="${fn:contains(msg, 'noid')}">
    		alert('가입하신 아이디가 없습니다.');
    	</c:if>
    	
    	<c:if test="${fn:contains(msg, 'findid')}">
			alert("가입하신 아이디는  ${id} 입니다.");
		</c:if>
	
		<c:if test="${fn:contains(msg, 'noinfo')}">
			alert('입력하신 정보를 확인해 주세요.');
		</c:if>
		
		<c:if test="${fn:contains(msg, 'findpw')}">
			alert("비밀번호는   ${pw}  입니다.");
		</c:if>
    </c:if>
    </script>
</head>
<body class="text-center">
	<div class="main_container">
	<div class="main_title"><h1>ID · PW 찾기</h1></div>
	<div class="main_left">
		<div class="main_center_sort">
			<form action="FindServlet?msg=id" method="post">
				<div >
					<label for="id_name" class="form-label">이름</label>
				    <input type="text" id="id_name" name="id_name" class="form-control" size="10">
			    </div>
			    
			    <div >
				    <label for="id_phone" class="form-label">전화번호</label>
				    <input type="text" id="id_phone" name="id_phone" class="form-control" size="10">
				</div>
		    	<button class="w-100 btn btn-lg btn-primary my-4" type="submit">ID 찾기</button>
	    	</form>
		</div>		
	</div>
	
	<div class="main_right">
		<div class="main_center_sort">
			<form action="FindServlet?msg=pw" method="post">
			    <div>
					<label for="pw_id" class="form-label">ID</label>
				    <input type="text" id="pw_id" name="pw_id" class="form-control" size="10">
			    </div>
				    
			   	<div>
					<label for="pw_name" class="form-label">이름</label>
				    <input type="text" id="pw_name" name="pw_name" class="form-control" size="10">
			    </div>
			    
			    <div>
				    <label for="pw_phone" class="form-label">전화번호</label>
				    <input type="text" id="pw_phone" name="pw_phone" class="form-control" size="10">
				</div>
				<button class="w-100 btn btn-lg btn-primary my-4" type="submit">PW 찾기</button>
			</form>
		</div>
	</div>
	<div class="main_list">
		<form action="MainServlet">
			<button class="w-100 btn btn-lg btn-primary my-4" type="submit">로그인 페이지로</button>
		</form>
	</div>
</div>
<script src="bootstrap-5.0/checkout/form-validation.js"></script>
</body>
</html>