<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="title"><a href="${pageContext.request.contextPath}/post/${post.id}">${post.name}</a></div>
<div class="date">
  <fmt:formatDate value="${post.date}" pattern="dd.MM.yyyy" />
  || комментариев: ${fn:length(post.comments)}
</div>
<div class="tags">
  <span style="vertical-align: middle;color:#999;">тэги:</span>
  <ul>
    <c:forEach var="tag" items="${post.tags}">
      <li><a href="${pageContext.request.contextPath}/tag/${tag.urlSlug}">${tag.name}</a></li>
    </c:forEach>
  </ul>
</div>