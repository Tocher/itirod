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
        <a href="${pageContext.request.contextPath}/" id="logo">Awesome Blog</a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/admin">DashBoard</a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/admin/post/list">Посты</a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/admin/tag/list">Тэги</a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/admin/comment/list">Комментарии</a>
      </li>
      <li>
        <c:url var="logoutUrl" value="${pageContext.request.contextPath}/j_spring_security_logout" />
        <form action="${logoutUrl}" method="post">
          <input type="submit" value="Log out" />
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
      </li>
    </ul>
  </nav>