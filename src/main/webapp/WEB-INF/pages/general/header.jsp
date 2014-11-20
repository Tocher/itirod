<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Awesome Blog</title>
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
  <nav>
    <ul class="head-nav">
      <li>
        <a href="/" id="logo">Awesome Blog</a>
      </li>
      <li>
        <a href="/">Главная</a>
      </li>
      <li style="display:none;">
        <a href="">Свежее</a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/popular">Популярное</a>
      </li>
      <li></li>
    </ul>
  </nav>