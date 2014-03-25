<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나무커뮤니티</title>
<link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${ctx}/resources/css/bootswatch.min.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 100px;
	padding-bottom: 40px;
	background-color: #ecf0f1;
}

.login-header {
	max-width: 400px;
	padding: 15px 29px 25px;
	margin: 0 auto;
	background-color: #2c3e50;
	color: white;
	text-align: center;
	-webkit-border-radius: 15px 15px 0px 0px;
	-moz-border-radius: 15px 15px 0px 0px;
	border-radius: 15px 15px 0px 0px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.login-footer {
	max-width: 400px;
	margin: 0 auto 20px;
	padding-left: 10px;
}

.form-signin {
	max-width: 400px;
	padding: 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	-webkit-border-radius: 0px 0px 15px 15px;
	-moz-border-radius: 0px 0px 15px 15px;
	border-radius: 0px 0px 15px 15px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 15px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}

.form-btn {
	text-align: center;
	padding-top: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<!-- header -->
		<div class="login-header">
			<h2 class="form-signin-heading">나무 커뮤니티</h2>
		</div>

		<!-- form -->
		<form class="form-signin" action="./user/login.do" method="post">
			<input type="text" name="loginId" class="form-control"
				id="inputEmail" placeholder="아이디"> <input type="password"
				name="loginPassword" class="form-control" id="inputPassword"
				placeholder="비밀번호"> <label class="checkbox"> <input
				type="checkbox" value="remember-me"> 아이디 기억하기
			</label>
			<div class="row form-btn">
			<button class="btn btn-large btn-warning" type="submit">로그인</button>
			<button class="btn btn-large btn-default"
				onclick="location.href='${ctx}/join.xhtml'; return false;">회원가입</button>
			</div>
		</form>

		<!-- footer -->
		<div class="login-footer">
			<p>© NamooSori 2014.</p>
		</div>
	</div>
</body>
</html>