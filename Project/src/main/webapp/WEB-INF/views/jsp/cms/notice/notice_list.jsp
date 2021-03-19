<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="row">
	<div class="col-lg-12">
		<div class="block">
			<div class="block-head">
				<h2>${title } 목록</h2>
			</div>
			<div class="block-content">		
				<form action="/cms/notice/noticeList.do" method="get" class="form-inline" id="searchForm">
					<input type="hidden" name="pageUnit" value="<c:out value='${paramMap.pageUnit}'/>" />
					<input type="hidden" name="pageSize" value="<c:out value='${paramMap.pageSize}'/>" />
					<input type="hidden" name="pageIndex" id="pageIndex" value="${paramMap.pageIndex }" />
					<fieldset>
					<legend class="sr-only">검색 폼</legend>
					
					<div class="form-group">
					<select name="searchCondition" id="boardSearchSelect02" class="form-control" title="검색기준">
						<option value="subject" <c:if test="${pramMap.searchCondition == 'subject'}">selected="selected"</c:if>>제목</option>
						<option value="content" <c:if test="${pramMap.searchCondition == 'content'}">selected="selected"</c:if>>내용</option>
					</select>
					</div>
					<div class="input-group">
						<input type="text" name="searchKeyword" id="searchKeyword" class="form-control" value="<c:out value='${param.searchKeyword}'/>" placeholder="검색어를 입력하세요" onkeydown="Enter_Check()">	
					</div>
					<div class="input-group">
						<span class="input-group-btn">
							<button type="button" onclick="fn_submit();" class="btn btn-default"><i class="fa fa-search"></i> 검색</button>
							<a href="/cms/notice/noticeList.do" class="btn btn-default"><i class="fa fa-refresh"></i> 초기화</a>
						</span>
					</div>
					</fieldset>
				</form>
			</div>
			
			<div class="block-content np">
				<form name="noticeListForm" action="${REQUEST_URI}" method="post">
					<fieldset>
						<table class="table">
							<colgroup>
								<col width="5%">
								<col width="*">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="10%">
							</colgroup>
							<thead>
								<tr>
									<th scope="col" class="text-center">번호</th>
									<th scope="col" class="text-center">제목</th>
									<th scope="col" class="text-center">작성자</th>
									<th scope="col" class="text-center">공개여부</th>
									<th scope="col" class="text-center">작성일</th>
									<th scope="col" class="text-center">조회수</th>
									<th scope="col" class="text-center">관리</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty resultList }">
										<c:forEach items="${resultList }" var="result" varStatus="status">
									
											<tr>
												<td class="text-center">
													${result.RNUM }
												</td>
												<td>
													<a href="/cms/notice/noticeWrite.do?noticeId=${result.BOARD_ID }&command=update" >${result.BOARD_TITLE }</a>
												</td>
												<td class="text-center">
													${result.BOARD_INSERT_USER }
												</td>
												<td class="text-center">
													<c:if test="${result.OPEN_YN eq 'Y'}">공개</c:if>
													<c:if test="${result.OPEN_YN ne 'Y'}">비공개</c:if>
												</td>
												<td class="text-center">
													${result.BOARD_INSERT_TIME }
												</td>
												<td class="text-center">
													${result.CLICK_CNT }
												</td>
												<td class="text-center">
													<a href="/cms/notice/noticeWrite.do?noticeId=${result.BOARD_ID }&command=update" class="btn btn-default btn-xs">수정</a>
													<a href="javascript:;" onclick="fn_cancle('/cms/notice/noticeDelete.do?noticeId=${result.BOARD_ID }');" class="btn btn-default btn-xs">삭제</a>							
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr><td colspan="7" class="text-left"><div>등록된 공지사항이 없습니다.</div></td></tr>
									</c:otherwise>
								</c:choose>
								
							</tbody>
						</table>
					</fieldset>
				</form>
			</div>
			<div class="block-footer">
				<div class="pull-left">
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
				<div class="pull-right">
					<a href="/cms/notice/noticeWrite.do?command=insert" class="btn btn-primary btn-sm pd-l-lg pd-r-lg">등록</a>
				</div>								
			</div>
		</div>
	</div>
</div>


