<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html class="no-js" lang="ko">
<head>
	<title>로그인</title>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	<link type="text/css" href="<c:out value='${pageContext.request.contextPath}'/>/resources/css/common/styles.css" rel="stylesheet"  id="theme"/>
	<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/jquery/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/jquery-validation/jquery.validate.min.js"></script>
	<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/jquery-validation/localization/messages_ko.js"></script>
</head>
<body>
<div class="page-container">
	<div class="page-content page-content-default">
		<div class="block-login">
			<div class="block-login-logo">
				
			</div>
			<div class="block-login-content">
				<h1>Login</h1>
				<form name="loginForm" id="loginForm" method="post">
					<div class="form-group">
						<input type="text" id="loginId" name="authId" class="form-control required" placeholder="ID" value="">
					</div>
					<div class="form-group">
						<input type="password" id="loginPw" name="authPw" class="form-control required" placeholder="Password" value="">
					</div>
					<button class="btn btn-primary btn-block" type="button" onclick="fn_submit();">Login</button>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function fn_submit(){
		var id = $("#loginId").val();
		var pw = $("#loginPw").val();
		if(id == ""){
			alert("아이디를 입력해주세요.");
			return;
		}
		
		if(pw == ""){
			alert("비밀번호를 입력해주세요.");
			return;
		}
		$("#loginForm").attr("action", "/auth/loginAction.do");
		$("#loginForm").submit();
	}
</script>
</body>
</html>