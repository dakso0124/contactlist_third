<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>연락처 추가 페이지</title>

<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/checkout/">
<link href="bootstrap-5.0/css/bootstrap.min.css" rel="stylesheet">
<style>
h3
{
  background: -webkit-linear-gradient(#ffd86f, #fc6262);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
label
{
	color: #9669F6;
}
body
{
	background-image: url("resource/background.gif");
	background-repeat: no-repeat;
	background-size: cover;
}
.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}
@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}
</style>
<link href="bootstrap-5.0/checkout/form-validation.css" rel="stylesheet">
</head>

<body>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
//영어와 숫자 입력 방지
function removeChar(e)
{
	var e 			= e || window.event
		,keyCode 	= (e.which) ? e.which : e.keyCode;

	if (keyCode == 8 || keyCode == 46 || keyCode == 37 || keyCode == 39) {
		return;
	} else {
		e.target.value = e.target.value.replace(/[^0-9]/g, '');
	};
}

// 그룹 직접 입력
function showfield(name)
{
	if(name=='Other')
  	{
		document.getElementById('selfinput').innerHTML='<div class="col-md-6"><label for="relation_name" class="form-label">직접 입력</label><input type="text" class="form-control" id="relation_name" name="relation_name" required><div class="invalid-feedback">그룹명을 입력해 주세요.</div></div>';
  	}
 	else
 	{
 		document.getElementById('selfinput').innerHTML='';
 	}
}
</script>
    
<div class="container">
  <main>
  <div class="col-lg-12">
    <div class="pt-5 text-center">
    	<h3 class="my-5">연락처 추가</h3>
    </div>

        <h4 class="mb-2" style=color:#9669f6>연락처 입력</h4>
        
        <form class="needs-validation" action="InsertContactServlet" method="post" novalidate>
          <div class="row g-3">
            <div class="col-12">
              <label for="name" class="form-label">이름</label>
              <div class="input-group">
                <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력해 주세요" required>
              <div class="invalid-feedback">
                  	이름을 입력해 주세요.
                </div>
              </div>
            </div>
            
            <div class="col-md-4">
              <label for="first_digit" class="form-label">전화번호</label>
              <select class="form-select" id="first_digit" name="first_digit" required>
                <option value="010">010</option>
                <option value="011">011</option>
                <option value="016">016</option>
                <option value="017">017</option>
                <option value="018">018</option>
                <option value="019">019</option>
              </select>
            </div>
            
            <div class="col-sm-4">
             <label class="pt-4"></label>
             <div class="input-group">
              <input type="text" class="form-control" id="second_digit" name="second_digit" value="" pattern=".{3,4}" required oninput="removeChar(event)" style="ime-mode:disabled"/>
              <div class="invalid-feedback">
              	전화번호를 입력해 주세요.
              </div>
              </div>
            </div>
            
            <div class="col-sm-4">
	            <label class="pt-4"></label>
	            <div class="input-group">
	            	<input type="tel" class="form-control" id="third_digit" name="third_digit" value="" pattern=".{4,4}" required onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'>
	            	<div class="invalid-feedback">
	              		전화번호를 입력해 주세요.
	            	</div>
	            </div>
            </div>
<div class="col-sm-12"></div>
<div class="col-md-4">

	<label for="group" class="form-label">그룹 선택</label>
<select class="form-select" name="group" id="group" onchange="showfield(this.options[this.selectedIndex].value)" required>
	<option selected="selected">그룹을 선택해 주세요</option>
	<option value="Other">직접 입력</option>
	<c:forEach items="${relations}" var="relation" >
		<option value="${relation.relation_name }" <c:if test="${relation.relation_name eq contact.relation_name}">selected</c:if>>${relation.relation_name }</option>
	</c:forEach>
</select>
</div>
<div class="col-md-8" id="selfinput"></div>

            <div class="col-12">
              <label for="memo" class="form-label">메모</label>
              <div class="input-group">
                <input type="text" class="form-control" id="memo" name="memo">
              </div>
            </div>

          <div class="my-4">
          	<button class="w-100 btn btn-primary btn-lg" type="submit">추가 하기</button>
          </div>
          </div>
        </form>
        </div>
  </main>

  <footer class="my-5"></footer>
</div>
      <script src="bootstrap-5.0/checkout/form-validation.js"></script>
  </body>
</html>