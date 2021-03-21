<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<title><c:out value="${title}"/></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link href="<c:out value='${pageContext.request.contextPath}'/>/resources/css/common/styles.css" rel="stylesheet" type="text/css" id="theme"/>
        <link href="<c:out value='${pageContext.request.contextPath}'/>/resources/css/common/jquery/jquery-ui.min.css" rel="stylesheet" type="text/css"/>

		<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/jquery/jquery-ui.min.js"></script>
		<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/jquery/jquery-ui-timepicker-addon.js"></script>
		<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/bootstrap/bootstrap.min.js"></script>
		<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>

		<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/jquery-validation/jquery.validate.min.js"></script>
		<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins/jquery-validation/localization/messages_ko.js"></script>

		<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/plugins.js"></script>
		<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/actions.js"></script>
        <script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/js/sys.js"></script>
	</head>
	
<%-- <%@include file="/WEB-INF/views/jsp/cms/include/header.jsp"%> --%>
<body>
	<div class="page-container">
		<div class="page-head">
	        <ul class="page-head-elements">
	            <li><a href="#" class="page-navigation-toggle"><span class="fa fa-bars"></span></a></li>
	        </ul>
	        <ul class="page-head-elements pull-right">
	            <li><a href="<c:url value='/auth/logout.do'/>" class="but dropdown-toggle" title="LOGOUT"><i class="fa fa-times"></i></a></li>
	        </ul>
	    </div>
	    
	    <div class="page-navigation">
	    	<!-- <div style="height: 100%;">
	    		
	    	</div> -->
	    	<div class="page-navigation-info">
	                <a href="/cms/notice/noticeList.do" class="logo">CMS</a>
	            </div>
	            
		        <div class="profile">
		            <div class="profile-info">
                        <%-- <a href="#" class="profile-title"><c:out value="${LOGIN_INFO.name}"/> (<c:out value="${LOGIN_INFO.id}"/>)</a> --%>
                        <span class="profile-subtitle">Administrator</span>
                    </div>
		        </div>
		        <ul class="navigation">
	            	<li class="openable">
	            		<a href="/cms/notice/noticeList.do"><i class="fa fa-file-o"></i>공지사항</a>
	            		<ul>
	            			<li>
	            				<a href="/cms/notice/noticeList.do">공지사항</a>
	            			</li>
	            		</ul>
	            	</li>
	            </ul>
	    	
	        
	        
	    </div>
	    <div class="page-content">
        	<div class="container">
        		<div class="page-toolbar">
        			<div class="page-toolbar-block">
        				<div class="page-toolbar-title">
        					${title }
        				</div>
        			</div>
        			<!-- 나중에 자동화 필요 -->
        			<ul class="breadcrumb">
        				<li>홈</li>
        				<li>공지사항</li>
        				<li>공지사항</li>
        			</ul>
        		
        		</div>
        		<c:import url="${contentFile}" />
        	</div>
        </div>
        <div class="page-sidebar"></div>
	</div>
	
	<button type="button" id="myModelBtn" class="btn btn-primary" style="display:none" data-toggle="modal" data-target="#myModal">Popup image</button>
	<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body"><img src="" class="img-responsive"></div>
			</div>
		</div>
	</div>
</body>
</html>