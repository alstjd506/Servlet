<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
	div.reply div{
		margin : auto;
	}
	div.reply ul {
		list-style-type : none;
		margin-top: 5px;
	}
	div.reply li {
		padding-top: 1px;
		padding-bottom: 1px;
	}
	div.reply span {
		display: inline-block;
	}

.center {
  text-align: center;
}


</style>
<link href="css/pagging.css" rel="stylesheet" />
<link href="css/modal.css" rel="stylesheet" />
<h3>상세화면</h3>

<c:choose>
   <c:when test="${empty result }">
      <p>조회된 결과가 없습니다.</p>
   </c:when>
   <c:otherwise>
      <form name="myFrm">
         <input type="hidden" name="bno" value="${result.boardNo }">
         <input type="hidden" name="page" value="${page }">
         <input type="hidden" name="searchCondition" value="${searchCondition }">
         <input type="hidden" name="keyword" value="${keyword }">
      </form>
      <table class="table">
         <tr>
            <th>게시글번호</th>
            <td>${result.boardNo }</td>
            <th>조회수</th>
            <td>${result.viewCnt }</td>
         </tr>
         <tr>
            <th>제목</th>
            <td>${result.title }</td>
            <th>작성자</th>
            <td>${result.writer }</td>
         </tr>
         <tr>
            <th>내용</th>
            <td colspan="4">${result.content }</td>
         </tr>
         <tr>
            <th width="11%">첨부파일</th>
            <td colspan="4" style="text-align: center" >
            <img src="/BoardWeb/images/${result.img }" alt ="${result.img }" style="max-width: 300px; heigth: auto; display:block; margin: 0 auto;">
            </td>
         </tr>
         <tr>
            <th>작성일자</th>
            <td colspan="3"><fmt:formatDate value="${result.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
         </tr>
         <tr align='center'>
            <td colspan='4'>
               <button class='btn btn-primary' id="modBtn">수정</button>
               <button class='btn btn-danger'>삭제</button>
            </td>
         </tr>

      </table>

   </c:otherwise>
</c:choose>
<div class="container reply">
	<div class ="header">
		<input class="col-sm-8" id="reply">
		<button class="col-sm-2" id="addReply">댓글등록</button>
		
	</div>
	<div class="content">
		<ul>
			<li>
				<span class="col-sm-2">글번호</span>
				<span class="col-sm-5">댓글내용</span>
				<span class="col-sm-2">작성자</span>
				<span class="col-sm-2">삭제</span>
			</li>
			<li>
				<hr />
			</li>
			<li style="display: none;">
				<span class="col-sm-2">2</span>
				<span class="col-sm-5">2댓글내용</span>
				<span class="col-sm-2">user02</span>
				<span class="col-sm-2"><button onclick="deleteRow(event)" class="btn btn-warning">삭제</button></span>
			</li>
		</ul>
	</div>
	<div class="footer">
		<div class="center">
 			<div class="pagination">
 				<a href="#">1</a>
 				<a href="#" class="active">2</a>
 				<a href="#">3</a>
 				<a href="#">4</a>
 			</div>
 		</div>
	</div>
</div> 

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <p>댓글번호: 123</p>
    <p><input type= "text" name="modal_reply"></p>
    <p><button class="btn">수정</button>
  </div>

</div>

<script>
	const bno = '${result.boardNo }';
	const writer = '${logId}';
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="js/replyService.js"></script>
<script src="js/jboard.js"></script>
<script src="js/jmodal.js"></script>
