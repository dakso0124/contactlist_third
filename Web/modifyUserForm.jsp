<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원 정보 수정 페이지</title>

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
	background-image: url("resource/background6.gif");
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

function addresspopup()
{
	new daum.Postcode(
		{
        	oncomplete: function(data) 
        	{
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var addr = ''; // 주소 변수
	            var extraAddr = ''; // 참고항목 변수
	
	            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	            if (data.userSelectedType === 'R') 	// 사용자가 도로명 주소를 선택했을 경우
	            {
	                addr = data.roadAddress;
	            }
				else								// 사용자가 지번 주소를 선택했을 경우(J) 
				{
	                addr = data.jibunAddress;
	            }
	
	            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	            if(data.userSelectedType === 'R')
	            {
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname))
	                {
	                    extraAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y')
	                {
	                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraAddr !== '')
	                {
	                    extraAddr = ' (' + extraAddr + ')';
	                }
	            }
	
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('postcode').value = data.zonecode;
	            document.getElementById("mainAddress").value = addr;
	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById("detailAddress").focus();
        	}
    }).open();
}
</script>
    
<div class="container">
  <main>
  <div class="col-lg-12">
    <div class="pt-3 text-center">
    	<h3 class="my-5">회원 정보 수정</h3>
			<!-- <img class="d-block mx-auto mb-4" src="resource/join2.png" alt="" width="128" height="128"> -->
    </div>

        <h4 class="mb-2" style=color:#9669f6>정보 입력</h4>
        
        <form class="needs-validation" action="ModifyUserServlet" method="post" novalidate>
          <div class="row g-3">
            <div class="col-sm-12">
              <label for="id" class="form-label">ID</label>
              <%-- <label for="id" class="form-label">${user.userid }</label> --%>
               <h5 class="mb-2" style=color:#9669f6>${user.userid }</h5>
            </div>
            
            <div class="col-12">
              <label for="pw" class="form-label">비밀번호 확인</label>
              <div class="input-group">
                <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력해 주세요" required>
              <div class="invalid-feedback">
                  	비밀번호를 입력해 주세요.
                </div>
              </div>
            </div>

            <div class="col-12">
              <label for="name" class="form-label">이름</label>
              <div class="input-group">
                <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력해 주세요" value="${user.name }" required>
              <div class="invalid-feedback">
                  	이름을 입력해 주세요.
                </div>
              </div>
            </div>

            <div class="col-md-4">
              <label for="first_digit" class="form-label">전화번호</label>
              <select class="form-select" id="first_digit" name="first_digit" required>
              	<option value="010" <c:if test="${user.phone1 eq 010}"> selected</c:if>>010</option>
              	<option value="011" <c:if test="${user.phone1 eq 011}"> selected</c:if>>011</option>
              	<option value="016" <c:if test="${user.phone1 eq 016}"> selected</c:if>>016</option>
              	<option value="017" <c:if test="${user.phone1 eq 017}"> selected</c:if>>017</option>
              	<option value="018" <c:if test="${user.phone1 eq 018}"> selected</c:if>>018</option>
              	<option value="019" <c:if test="${user.phone1 eq 019}"> selected</c:if>>019</option>
              </select>
            </div>
            
            <div class="col-sm-4">
             <label class="pt-4"></label>
              <input type="text" class="form-control" id="second_digit" name="second_digit" value="${user.phone2 }" pattern=".{3,4}" maxlength="4" required oninput="removeChar(event)" style="ime-mode:disabled"/>
              <div class="invalid-feedback">
              	전화번호를 올바르게 입력해 주세요.
              </div>
            </div>
            
            <div class="col-sm-4">
	            <label class="pt-4"></label>
	            	<input type="text" class="form-control" id="third_digit" name="third_digit" value="${user.phone3 }" pattern=".{4,4}" maxlength="4" required onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'>
	            	<div class="invalid-feedback">
	              		전화번호를 올바르게 입력해 주세요.
	            	</div>
            </div>
            
            <div class="col-md-2">
            	<label for="postcode" class="form-label">우편번호</label>
                <input type="text" class="form-control" id="postcode" name="postcode" value="${user.zipcode }" required>
              	<div class="invalid-feedback">
                  	주소를 입력해 주세요.
                </div>
            </div>
            <div class="col-sm-4">
            <label class="pt-1"></label>
            	<div class="py-2">
	      			<button class="w-80 btn btn-primary btn-MD" type="button" onclick="addresspopup()">우편번호 찾기</button>
	      		</div>
            </div>
            
            <div class="col-12">
              <label for="address" class="form-label">주소</label>
                <input type="text" class="form-control" id="mainAddress" name="mainAddress" placeholder="" value="${user.mainaddress }" required>
              <div class="invalid-feedback">
                  	주소를 입력해 주세요.
                </div>
            </div>
            
            <div class="col-12">
              <label for="detailAddress" class="form-label">상세 주소</label>
                <input type="text" class="form-control" id="detailAddress" name="detailAddress" placeholder="상세주소" value="${user.detailaddress }">
            </div>
            

          <div class="my-4">
          	<button class="w-100 btn btn-primary btn-lg" type="submit">수정하기</button>
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