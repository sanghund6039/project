<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><c:out value="${title}"/></title>
	<link href="<c:out value='${pageContext.request.contextPath}'/>/resources/css/front/front.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/jquery/jquery-ui.min.js"></script>
</head>
<body>
	<div id="wrap">
		<header id="mainHeader">
			<div class="contents clearfix">
				<div class="right clearfix">
					<div class="gnb">
						<div class="gnb_area">
							<ul class="nav clearfix">
								<li>
									<a href="javascript:;">
										<span>공지사항</span>
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</header>
		
		<div id="container" class="sub">
			<div class="bg_page_tit">
				<div class="contents">
					<ul class="breadcrumb"><li>HOME</li> <li>공지사항</li></ul>
					<h3 class="page_tit">공지사항</h3>
				</div>
			</div>
			
			<div class="contents" style="padding-top: 50px; padding-bottom: 60px;">
				<c:import url="${contentFile}" />
			</div>		
		</div>
	</div>
</body>
</html>