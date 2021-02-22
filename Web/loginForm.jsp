<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 페이지</title>
	<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">

	<link href="bootstrap-5.0/css/bootstrap.min.css" rel="stylesheet">
	 	<style>
	 		body
	 		{
	 			background-image: url("resource/background5.gif");
	 			background-repeat: repeat-x;
	 			background-size: contain;
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
			  background: -webkit-linear-gradient(#fbcac9, #8ca6ce);
			  -webkit-background-clip: text;
			  -webkit-text-fill-color: transparent;
			}
						    
	    </style>
    <link href="bootstrap-5.0/sign-in/signin.css" rel="stylesheet">
    
    <script type="text/javascript">
    
  	//alert
    <c:if test="${msg ne null }">
    	<c:set var="msg" value="${msg}"/>
    	
    	<c:if test="${fn:contains(msg, 'invalid')}">
    		alert('아이디 혹은 비밀번호를 확인해 주세요');
    	</c:if>
    	
    	<c:if test="${fn:contains(msg, 'timeout')}">
			alert('세션이 만료되었습니다.');
		</c:if>
    </c:if>
    </script>
</head>
<body class="text-center">
<main class="form-signin">
<div class="col-lg-12">
	<form class="needs-validation" action="LoginServlet" method="post" novalidate>
		<h1 style="color: white">로그인 페이지</h1>
		<img class="mb-4" src="resource/logo.png" alt="" width="256" height="256">
		<div>
			<label for="id" class="visually-hidden"></label>
		    <input type="text" id="id" name="id" class="form-control" placeholder="ID를 입력해 주세요" size="10" required autofocus>
		    <div class="invalid-feedback">
	                	ID를 입력해 주세요.
	        </div>
	    </div>
	    
	    <div>
		    <label for="pw" class="visually-hidden">Password</label>
		    <input type="password" id="pw" name="pw" class="form-control" placeholder="PW를 입력해 주세요" size="10" required>
		    <div class="invalid-feedback">
	                	비밀번호를 입력해 주세요.
	        </div>
		</div>
    	<button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
    </form>
	    
   	<div class="mt-4">
   	</div>
	<div class="row g-3">
		<div class="col-sm-6">
			<form action="JoinServlet" method="get">
				<button class="w-100 btn btn-md btn-primary" type="submit">회원 가입</button>
			</form>
		</div>
		<div class="col-sm-6">
			<form action="FindServlet" method="get">
				<button class="w-100 btn btn-md btn-primary" type="submit">ID PW 찾기</button>
			</form>
		</div>
	</div>
</div>
</main>
<script src="bootstrap-5.0/checkout/form-validation.js"></script>
</body>
</html>