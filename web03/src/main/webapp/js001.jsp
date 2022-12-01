<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function idcheck() {
	myid = document.getElementById('id').value
	
	result=""
	if (myid.length >= 5) {
		result = "5글자 이상입니다. 유효합니다"
	}else {
		result ="5글자 미만입니다. 다시입력해주세요"
	}
	alert(result)
}
function pwcheck() {
	mypw = document.getElementById('pw1').value
	mypw2 = document.getElementById('pw2').value
	
	if (mypw == mypw2){
		result2 = '비밀번호가 일치합니다.<img src="img.jpg">'
	} else{
		result2 = "비밀번호가 일치하지 않습니다."
	}
	resultTag = document.getElementById("result")
	resultTag.innerHTML = result2
}
</script>
</head>
<body>
<h3>자바스크립트 테스트 </h3>
<hr>
아이디 : <input name="id" id="id"> <button onclick="idcheck()">글자수 체크</button><br>
비밀번호 : <input name="pw1" id="pw1"> <br>
비밀번호 확인 : <input name="pw2" id="pw2"> <button onclick="pwcheck()">비밀번호 확인</button> <br> 
<hr>
<div id="result"></div>

</body>
</html>