<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나무커뮤니티</title>
</head>
<body>
	<h2>나무 커뮤니티</h2>
	<form action="./user/login.do" method="post">
		<input type="text" name="loginId" class="form-control" id="inputEmail"	placeholder="아이디"> 
		<input type="password" name="loginPassword" class="form-control" id="inputPassword" placeholder="비밀번호">
		
		<button class="btn btn-large btn-warning" type="submit">로그인</button>
        <button class="btn btn-large btn-default" onclick="location.href='${ctx}/user/join.do'; return false;">회원가입</button>

	</form>
</body>
</html>