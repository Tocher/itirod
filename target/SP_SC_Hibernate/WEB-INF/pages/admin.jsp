<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="general/header_admin.jsp"%>
<div class="wrapper">
	<div>Всего постов: ${postCount}</div>
	<br>
	<div>Всего тэгов: ${tagCount}</div>
	<br>
	<div>Всего комментариев: ${commentCount}</div>
</div>
<%@include file="general/footer.jsp"%>