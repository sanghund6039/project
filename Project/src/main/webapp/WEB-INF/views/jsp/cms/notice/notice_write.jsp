<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	function onSubmit(){
		
		if(!$("#noticeTit").val()){
			alert("제목을 입력하세요.");
			return;
		}
		
		var colCkeditor = CKEDITOR.instances['noticeContent']; 
		if (colCkeditor.getData()=="")
		{
			alert("내용을 입력하세요.");
			colCkeditor.focus();
			return;
		}
		
		if(confirm("완료하시겠습니까?")){
			noticeWriteForm.submit();
		}
	}
	
	function fn_cancle(){
		if(confirm("취소하시겠습니까? 취소하면 내용은 저장되지 않습니다.")){
			location.href="/cms/notice/noticeList.do";
		}
	}
</script>

<div class="row">
	<div class="col-lg-12">
		<form name="noticeWriteForm" action="/cms/notice/noticeWriteAct.do" enctype="multipart/form-data" class="form-horizontal" method="post">
			<input type="hidden" name="command" value="${paramMap.command }">
			<input type="hidden" name="boardId" value="${map.BOARD_ID }">
			<div class="block">
				<div class="block-head">
					<h1>${title }</h1>
				</div>
				<div class="block-content">
					<fieldset>
						<legend class="sr-only">공지사항 폼</legend>
						<div class="form-group">
							<span class="col-sm-2 text-right"><label for="openYn" class="control-label">주요여부</label></span>
							<div class="col-sm-10">
								<label class="check-inline" style="position: relative;">
									<c:choose>
										<c:when test="${map.TOP_YN eq 'Y' }">
											<input type="checkbox" style="margin-top:8px;" name="topYn" checked/>	
										</c:when>
										<c:otherwise>
											<input type="checkbox" style="margin-top:8px;" name="topYn"/>
										</c:otherwise>
									</c:choose>
									 
								</label>
								<span>
									<label class="check-inline" style="position: relative;">
										주요
									</label>
								</span>
							</div>
						</div>
						
						<div class="form-group">
							<span class="col-sm-2 text-right"><label for="noticeTit" class="control-label">* 제목</label></span>
							<div class="col-sm-10">
								<input name="noticeTit" id="noticeTit" class="form-control required"  value="${map.BOARD_TITLE }" required="required"/>
							</div>
						</div>
						
						<div class="form-group">
							<span class="col-sm-2 text-right"><label for="openYn" class="control-label">공개여부</label></span>
							<div class="col-sm-10">
								<label class="radio-inline">
									<input type="radio" name="openYn" value="Y" <c:if test="${map.OPEN_YN eq null or map.OPEN_YN eq 'Y' }">checked="checked"</c:if>/>공개
								</label>
								<label class="radio-inline">
									<input type="radio" name="openYn" value="N" <c:if test="${map.OPEN_YN eq 'N' }">checked="checked"</c:if> />비공개
								</label>
							</div>
						</div>
						
						<div class="form-group">
							<span class="col-sm-2 text-right">
								<label for="colItr" class="control-label">* 내용</label>
							</span>
							<div class="col-sm-10">
								<span class="tip MAT7">Tip</span>공지사항 내용이 표출됩니다.
								<textarea name="noticeContent" id="noticeContent" class="form-control"><c:out value='${map.BOARD_CONTENT }'/></textarea>
								<script type="text/javascript">
									CKEDITOR.replace("noticeContent",{
									    filebrowserUploadUrl : "/imageUpload.do"
									}); 
								</script>
							</div>
						</div>
						
						<div class="form-group">
							<span class="col-sm-2 text-right">
								<label for="imageFile" class="control-label">첨부파일</label>
							</span>
							<div class="col-sm-8">
								<input type="file" name="imageFile" id="imageFile" class="form-control" />
								<input type="hidden" name="imgUrl" value="">
								<span class="tip MAT7">Tip</span> 파일유형은 gif,jpg,jpeg,png,zip,hwp,docx,pdf,xls,xlsx, txt만 가능합니다.
								<br>
								
								<c:if test="${not empty filemap.resultList }">
									<c:forEach items="${filemap.resultList }" var="list" varStatus="status">
										<p>${list.FILE_NM }</p>
									</c:forEach>
								</c:if>
							</div>
						</div>
						
						<c:if test="${not empty map.BOARD_INSERT_USER }">
							<div class="form-group">
								<span class="col-sm-2 text-right"><label for="openYn" class="control-label">작성자</label></span>
								<div class="col-sm-10">
									<label class="text-inline" style="margin-top:6px;">
										${map.BOARD_INSERT_USER }
									</label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${not empty map.BOARD_INSERT_TIME }">
							<div class="form-group">
								<span class="col-sm-2 text-right"><label for="openYn" class="control-label">작성일</label></span>
								<div class="col-sm-10">
									<label class="text-inline" style="margin-top:6px;">
										${map.BOARD_INSERT_TIME }
									</label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${not empty map.BOARD_UPDATE_USER }">
							<div class="form-group">
								<span class="col-sm-2 text-right"><label for="openYn" class="control-label">최종 수정자</label></span>
								<div class="col-sm-10">
									<label class="text-inline" style="margin-top:6px;">
										${map.BOARD_UPDATE_USER }
									</label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${not empty map.BOARD_UPDATE_TIME }">
							<div class="form-group">
								<span class="col-sm-2 text-right"><label for="openYn" class="control-label">최종 수정일</label></span>
								<div class="col-sm-10">
									<label class="text-inline" style="margin-top:6px;">
										${map.BOARD_UPDATE_TIME }
									</label>
								</div>
							</div>
						</c:if>
						
					</fieldset>
					<div class="bd-t mg-t-md pd-t-md"></div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<a class="btn btn-primary pd-l-lg pd-r-lg" onclick="javascript:onSubmit();">저장</a>
							<a href="javascript:;" onclick="fn_cancle();" class="btn btn-default pd-l-lg pd-r-lg">취소</a>
						</div>
					</div>
				</div>
			</div>
		</form>			
	</div>
</div>
