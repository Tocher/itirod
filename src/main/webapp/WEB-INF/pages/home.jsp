<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="general/header.jsp"%>
<div class="wrapper">
	<div class="left">
		<c:forEach var="post" items="${posts}">
			<div class="post">
				<%@include file="post/post.jsp"%>
				<div class="content">
					${post.content}
				</div>
			</div>
		</c:forEach>
		<c:if test="${prevPage > 0}">
			<a class="pagination_left" href="/page/${prevPage}"><< Вернуться</a>
		</c:if>
		<c:if test="${nextPage > 0}">
			<a class="pagination_right" href="/page/${nextPage}">Далее >></a>
		</c:if>
	</div>
	<%@include file="general/sidebar.jsp"%>
</div>
<%@include file="general/footer.jsp"%>