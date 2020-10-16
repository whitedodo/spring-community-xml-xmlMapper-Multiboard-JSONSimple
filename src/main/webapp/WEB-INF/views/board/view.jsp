<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardTitle} - 세부 항목</title>
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
		
	h1{
		text-align:center;
	}
	
	.foot_tbl{
		width:700px;
		text-align:center;
		margin:auto;
	}
	
</style>
</head>
<body>

<!-- 상단 -->
<a href="logout.do">Log-out</a>
<h1>글 상세</h1>
<hr />

<!-- 본문 -->
<input name="id" type="hidden" value="${boardView.id}" />

<table class="board_tbl">
	<tr>
		<td bgcolor="orange" width="70">작성자명</td>
		<td align="left"><input name="title" type="text"
			value="${boardView.name}" /></td>
	</tr>
	<tr>
		<td bgcolor="orange">제목</td>
		<td align="left">${boardView.subject}</td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td align="left">
			<textarea name="content" cols="40" rows="10">${boardView.memo}</textarea>
		</td>
	</tr>
	<tr>
		<td bgcolor="orange">등록일</td>
		<td align="left">${boardView.regidate }</td>
	</tr>
	<tr>
		<td bgcolor="orange">조회수</td>
		<td align="left">${boardView.count}</td>
	</tr>
</table>

<hr>

<!-- 하단 메뉴 -->
<table class="foot_tbl">
	<tr>
		<td>
			<a href="${pageUrl}/insert/${boardname}">등록</a>
		</td>
		<td>
			<a href="${pageUrl}/delete/${boardname}?page=${pageid}">삭제</a>		
		</td>
		<td>
			<a href="${pageUrl}/list/${boardname}">글 목록</a>		
		</td>
	</tr>
</table>

</body>
</html>