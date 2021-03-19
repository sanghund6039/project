<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">
	function fn_list(){
		location.href="/front/notice.do";
	}
</script>

<div class="board_view">
	<div class="tit_area clearfix">
		<div class="tit">
			<strong>${result.BOARD_TITLE }</strong>
		</div>
		<ul class="info clearfix">
			<li>등록일  <span>${result.BOARD_INSERT_TIME }</span></li>
			<li>조회수  <span>${result.CLICK_CNT }</span></li>
		</ul>
	</div>
	<div class="cont_area">
		<div class="cont">
			${result.BOARD_CONTENT }
		</div>
	</div>
	<div class="cont_area">
		<div style="padding: 30px 10px;">
			<p style="font-weight: bold; font-size:15px;">첨부파일</p><br>
			<p><a href="/resources/upload/notice/${filemap.FILE_NM }" target="_blank" download>${filemap.FILE_NM }</a></p> 
		</div>
	</div>
</div>
<div class="btn_area">
	<a href="javascript:;" onclick="fn_list();" class="btn btn_md btn_line_keycolor">목록</a>
</div>