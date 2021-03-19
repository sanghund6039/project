<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	<c:choose>
		<c:when test="${message == 'auth.success'}">
			document.location.href = "<c:url value='${goUrl}'/>"; /* /popup/mainvisual.do */
		</c:when>
		<c:when test="${message == 'auth.fail'}">
			alert("아이디 혹은 비밀번호를 확인 후 다시 입력해 주세요.");
			history.back(-1);
		</c:when>		
	</c:choose>
</script>