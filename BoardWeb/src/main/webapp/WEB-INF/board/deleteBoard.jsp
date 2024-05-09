<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
BoardVO vo = (BoardVO) request.getAttribute("bno");
%>
<%
if (vo == null) {
%>
<p>조회된 결과가 없습니다.</p>
<%
} else {
%>
<h3>삭제화면</h3>
<form action="deleteBoard.do">
	<table class="table">
		<tr>
			<th>게시글번호</th>
			<td><%=vo.getBoardNo()%></td>
			<th>조회수</th>
			<td><%=vo.getViewCnt()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=vo.getTitle()%></td>
			<th>작성자</th>
			<td><%=vo.getWriter()%></td>
		</tr>
		<tr>
			<td colspan="4"><%=vo.getContent()%></td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td colspan="3"><%=vo.getCreateDate()%></td>
		</tr>
		<tr align='center'>
			<td colspan='4'>
				<button class='btn btn-danger'>삭제</button>
			</td>
		</tr>
	</table>
	<input type="hidden" name="bno" value=<%=vo.getBoardNo()%>>
</form>
<%
}
%>

<jsp:include page="../includes/footer.jsp"></jsp:include>