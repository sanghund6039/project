<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<script type="text/javascript">
	function Enter_Check(){
	    // 엔터키의 코드는 13입니다.
		if(event.keyCode == 13){
			fn_submit();
		}
	}
	
	function fn_submit(){
		$("#pageIndex").val("1");
		$("#searchForm").submit();
	}
	
	function fn_linkToPage(page){
		$("#pageIndex").val(page);
		$("#searchForm").submit();
	}
	
	function fn_reset(){
		location.href="/front/notice.do";
	}
</script>

<section id="page">
	<div class="page_notice">
		<div class="div__content_root">
			<div class="board_top clearfix">
				<div class="search_area">
					<form action="/front/notice.do" method="get" id="searchForm">
						<input type="hidden" name="pageUnit" value="<c:out value='${paramMap.pageUnit}'/>" />
						<input type="hidden" name="pageSize" value="<c:out value='${paramMap.pageSize}'/>" />
						<input type="hidden" name="pageIndex" id="pageIndex" value="${paramMap.pageIndex }" />
						<select name="searchCondition" id="searchCondition" class="select">
							<option value="subject" <c:if test="${paramMap.searchCondition == 'subject'}">selected="selected"</c:if>>제목</option> 
							<option value="content" <c:if test="${paramMap.searchCondition == 'content'}">selected="selected"</c:if>>내용</option>
						</select> 
						 
						<input type="text" name="searchKeyword" id="searchKeyword" class="search" value="<c:out value='${param.searchKeyword}'/>" placeholder="검색어를 입력하세요" onkeydown="Enter_Check()">
						<button type="button" onclick="fn_submit();" class="btn btn_md btn_keycolor">검색</button> 
						<button type="button" onclick="fn_reset();" class="btn btn_md btn_subcolor">검색 초기화</button>
					</form>
				</div>
				<div class="total_num">총 <b>${resultCnt }</b>개</div>
			</div>
			<ul class="board_list">
				<li class="thead">
					<strong class="num">번호</strong> 
					<strong class="tit">제목</strong> 
					<strong class="date">등록일</strong> 
					<strong class="hits">조회수</strong>
				</li>
				<c:choose>
					<c:when test="${not empty resultList }">
						<c:forEach items="${resultList }" var="result" varStatus="status">
							<li class="<c:if test="${result.TOP_YN eq 'Y' }">notice</c:if>">
								<div class="num">
									<span>
										<c:if test="${result.TOP_YN eq 'Y' }"><i class="material-icons"></i>${result.RNUM }</c:if>
										<c:if test="${result.TOP_YN ne 'Y' }">${result.RNUM }</c:if>
									</span>
								</div> 
								<div class="tit"><a href="/front/noticeView.do?noticeId=${result.BOARD_ID }">${result.BOARD_TITLE }</a></div> 
								<div class="date">${result.BOARD_INSERT_TIME }</div> 
								<div class="hits">${result.CLICK_CNT }</div>
							</li>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<li>
							<div class="num">등록된 공지사항이 없습니다.</div>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		
		<div class="block-footer" style="padding-top: 15px; text-align: center;">
			<div class="pull-center">
				<c:if test="${not empty resultList }">
					<ul class="pagination pagination-sm">
						<c:if test="${resultCnt%10 eq 0 }"><c:set value="${(resultCnt/10) }" var="lastPage"/></c:if>
                       	<c:if test="${resultCnt%10 ne 0 }"><c:set value="${(resultCnt/10)+1 }" var="lastPage" /></c:if>
                       	<fmt:parseNumber value="${lastPage }" pattern="###" integerOnly="true" type="number" var="lastPageNum"/>
                       	<c:set var="pages" value="${paramMap.pageIndex/10 }"/>
                       	<fmt:parseNumber value="${(pages+((1-pages%1)%1))-1 }" var="firstPage"/>
                       	<c:set value="${firstPage*10+1 }" var="firstPageOnList"/>
                       	<c:set value="${firstPageOnList+10-1 }" var="lastPageOnList"/><c:if test="${lastPageOnList gt lastPage }"><c:set value="${lastPageNum }" var="lastPageOnList"/></c:if>
                       	<c:set value="${firstPageOnList+10 }" var="nextPage"/><c:if test="${nextPage gt lastPageNum }"><c:set value="${lastPageNum }" var="nextPage"/></c:if>
                       	<c:set value="${firstPageOnList-10 }" var="prevPage"/><c:if test="${prevPage le 0 }"><c:set value="1" var="prevPage"/></c:if>
						
						<c:choose>
							<c:when test="${paramMap.pageIndex eq 1 }">
								<li class="first disabled"><a href="#">처음</a></li>
								<li class="prev disabled"><a href="#">이전</a></li>
							</c:when>
							<c:otherwise>
								<li class="first"><a href="javascript:;" onclick="fn_linkToPage('1');">처음</a></li>
								<li class="prev"><a href="javascript:;" onclick="fn_linkToPage('${prevPage}');">이전</a></li>
							</c:otherwise>
						</c:choose>
						
						
						<c:forEach begin="${firstPageOnList }" end="${lastPageOnList }" step="1" var="paging">
							<c:choose>
								<c:when test="${paramMap.pageIndex eq paging }"><li class="active"><a href="#"><c:out value="${paging }"/></a></li></c:when>
								<c:otherwise><li><a href="javascript:;" onclick="fn_linkToPage('${paging}')"><c:out value="${paging }"/></a></li></c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:choose>
							<c:when test="${paramMap.pageIndex eq lastPageNum }">
								<li class="next disabled"><a href="#">다음</a></li>
								<li class="last disabled"><a href="#">마지막</a></li>
							</c:when>
							<c:otherwise>
								<li class="next"><a href="javascript:;" onclick="fn_linkToPage('${nextPage}');">다음</a></li>
								<li class="last"><a href="javascript:;" onclick="fn_linkToPage('${lastPageNum}');">마지막</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</c:if>
			</div>								
		</div>	
	</div>
</section>   
