<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
	<title>Hello, Communities (스마일! 미니 프로젝트)</title>
    <meta charset="utf-8">
	<style>
		.mini_table{
			font-family: Arial;
			font-size: 15px;
			width:700px;
			border-top:1px solid #e2e2e2;
			margin:auto;
			text-align:center;
			border-collapse: collapse;
		}
		
		
		.mini_table thead td{
			background-color:#e6e6e6;
		}
		
		.mini_table td{
			border-right:1px solid #e2e2e2;
			border-bottom:1px solid #e2e2e2;
		}
		
		.mini_title{
			text-align:center;

		}
		
		
	</style>
</head>
<body>
<h1 class="mini_title">Welcome to MyHome</h1>

<table class="mini_table">
	<thead>
		<tr>
			<td style="width:15%">
				번호(Num)
			</td>
			<td style="width:50%">
				사이트명(Sitename)
			</td>
			<td style="border-right:0px;">
				링크(Link)
			</td>
		</tr>
	</thead>
	<!-- 인트라넷(커뮤니티) 영역 -->
	<tr>
		<td>
			1
		</td>
		<td>
			<a href="myhome/login">My Communities Site</a>
		</td>
		<td style="border-right:0px;">
			링크(Link)
		</td>
	</tr>
	<tr>
		<td>
			2
		</td>
		<td>
		
		</td>
		<td style="border-right:0px;">
			링크(Link)
		</td>
	</tr>
</table>
	

</body>
</html>
