<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 - ${boardTitle}</title>
<style>
	.board_tbl{
		border-top:1px solid #666;
		width:700px;
		
		font-family:Arial;
		font-size:15px;
		margin:auto;
		text-align:center;
		
	}
	
	.board_tbl td{
		border-right:1px solid #e6e6e6;
		border-bottom:1px solid #333;
		height:20px;
		text-align:center;
	}
	
	.board_tbl th{
		background-color:#e6e6e6;
		border-bottom:1px solid #e2e2e2;
	}
	
	.board_title{
		font-size:20px;
		text-align:center;
	}
	
</style>
</head>
<body>

<!-- 상단 -->
<h3 class="board_title">게시판 목록(Index Board)</h3>
<hr/>

<table class="board_tbl">
	<tr>
		<th style="width:10%;">
			번호(num)
		</th>
		<th style="width:40%;">
			제목(subject)
		</th>
		<th style="width:10%;">
			작성자(author)
		</th>
		<th style="width:10%;">
			조회수(count)
		</th>
		<th style="width:15%;">
			등록일자(regidate)
		</th>
	</tr>
	<c:forEach items="${boardList}" var="board">
		<tr>
			<td>${board.id }</td>
			<td align="left">
				<a href="${pageUrl}/view/${boardname}?page=${board.id}">${board.subject}</a>
			</td>
			<td>${board.name}</td>
			<td>${board.count}</td>
			<td style="border-right:0px">
				<fmt:formatDate value="${board.regidate}" pattern="yyyy-MM-DD hh:mm:ss"/>
			</td>
		</tr>
	</c:forEach>
</table>

<!-- 금액 형식: <fmt:formatNumber value="12341230" /> -->

<!-- 페이징 -->
<div style="text-align:center">
<jsp:include page="/WEB-INF/views/pager/paging.jsp">
	<jsp:param name="customURL" value="${pagingUrl}?" />
    <jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
    <jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
    <jsp:param name="startPageNo" value="${paging.startPageNo}" />
    <jsp:param name="pageNo" value="${paging.pageNo}" />
    <jsp:param name="endPageNo" value="${paging.endPageNo}" />
    <jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
    <jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
</jsp:include>
</div>

</body>
</html>