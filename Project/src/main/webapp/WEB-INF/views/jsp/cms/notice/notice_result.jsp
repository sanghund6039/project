<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type="text/javascript">
	<c:choose>
		<c:when test="${message == 'success.common.insert'}">
			alert("등록되었습니다.");
			document.location.href = "${returnUrl}";
		</c:when>
		<c:when test="${message == 'success.common.update'}">
			alert("수정되었습니다.");
			document.location.href = "${returnUrl}";
		</c:when>
		<c:when test="${message == 'success.common.delete'}">
			alert("삭제되었습니다.");
			document.location.href = "${returnUrl}";
		</c:when>
		<c:when test="${message == 'success.common.nodata'}">
			alert("자료가없습니다.");
			document.location.href = "${returnUrl}";
		</c:when>
	</c:choose>
</script>