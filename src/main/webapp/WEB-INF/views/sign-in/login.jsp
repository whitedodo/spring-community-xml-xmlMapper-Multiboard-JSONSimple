<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="ko-kr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Hello World">

    <title>${pageTitle} - Communities</title>
	
    <!-- Bootstrap core CSS -->
	<link href="${contextPath}/resources/bootstrap-4.5.3/assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="${contextPath}/resources/myhome/signin.css" rel="stylesheet">
    
  	</head>
  
  	<body class="text-center">
  	
    <form class="form-signin" action="authorize" method="POST">
		<img class="mb-4" src="${contextPath}/resources/myhome/logo.jpg" alt="">
		
		<input type="hidden" name="token" value="${token }" />
		
		<h1 class="h3 mb-3 font-weight-normal">로그인 해주세요</h1>
		<label for="inputEmail" class="sr-only">이메일(email)</label>
		<input name="username" type="email" id="inputEmail" class="form-control" placeholder="이메일 주소(Email Address)" required autofocus>
		<label for="inputPassword" class="sr-only">비밀번호(Password)</label>
		<input name="passwd" type="password" id="inputPassword" class="form-control" placeholder="비밀번호(Password)" required>
		
  		<button class="btn btn-lg btn-primary btn-block" type="submit">로그인(Login)</button>
  		<p class="mt-5 mb-3 text-muted">&copy; 2020</p>
	</form>
</body>
</html>
