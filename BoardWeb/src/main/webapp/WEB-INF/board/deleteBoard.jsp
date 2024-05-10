<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<c:choose>
	<c:when test="${empty bno }">
		<p>조회된 결과가 없습니다.</p>
	</c:when>
	<c:otherwise>
<h3>삭제화면</h3>
<form name="myFrm" action="deleteBoard.do">
	<table class="table">
		<tr>
			<th>게시글번호</th>
			<td>${bno.boardNo }</td>
			<th>조회수</th>
			<td>${bno.viewCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${bno.title }</td>
			<th>작성자</th>
			<td>${bno.writer }</td>
		</tr>
		<tr>
			<td colspan="4">${bno.content }</td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td colspan="3">${bno.createDate }</td>
		</tr>
		<tr align='center'>
			<td colspan='4'>
				<input class='btn btn-danger' type= "submit">
			</td>
		</tr>
	</table>
	<input type="hidden" name="bno" value=${bno.boardNo }>
	<input type="hidden" name="page" value=${page }>
</form>
<script type="text/javascript">
 const logid = "${logId}";
 const writer = "${bno.writer }";
 
 document.forms.myFrm.addEventListener('submit', function(e){
	e.preventDefault(); 
	if(logid != writer){
		alert("권한이 없습니다.");
		return;
	}
	this.submit();
 
 });
 
</script>
	</c:otherwise>
</c:choose>
<jsp:include page="../includes/footer.jsp"></jsp:include>