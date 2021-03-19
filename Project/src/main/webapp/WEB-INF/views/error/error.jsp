<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<c:url value='/css/egovframework/sample.css'/>"/>
<title>error</title>
<style type="text/css">

	.error{background:#ebeced;}
	.error_msg{padding:300px 0 70px 0;text-align:center;color:#000;line-height:20px;font-size:14px;font-weight:bold;background:#ebeced url('http://eco.gwangju.go.kr/images/common/errorBg.png') 50% 70px no-repeat}
	.error_msg p{margin-bottom:15px;}
	.error_msg .error_btn{padding-top:15px;}

	a.move_btn{display:inline-block;width:150px;height:35px;border:1px solid #93041c;color:#fff;background-color:#ae1932;line-height:35px;font-size:1em;text-align:center;font-weight:bold;vertical-align:middle}
	/*background-color:#0f5abd;*/
</style>
</head>
<body class="error">

	<div class="error_msg">
		<p>방문하시려는 페이지의 주소가 잘못 입력되었거나,<br>페이지의 주소가 변경 혹은 삭제되어, 요청하신 페이지를 찾을 수 없습니다.</p>
		<p>입력하신 주소가 정확한지 다시 한번 확인해 주시기 바랍니다.</p>
		<!-- <p>관련 문의사항은 관리자에게 알려주시면 친절하게 안내해 드리겠습니다.</p> -->
		<p class="error_btn">
			<a href="javascript:history.back();" class="move_btn">이전페이지로 이동</a>
		</p>
	</div>

 
</body>
</html>