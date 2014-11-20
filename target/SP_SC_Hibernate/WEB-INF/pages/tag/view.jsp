<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../general/header.jsp"%>
<div class="wrapper">
  <div class="left">
    <h4>посты по тэгу:</h4>
    <h3>${tag.name}</h3>
    <c:forEach var="post" items="${tag.posts}">
    <div class="post">
      <div class="title">${post.name}</div>
      <div class="date">
        <fmt:formatDate value="${post.date}" pattern="yyyy MM dd" />
      </div>
      <div class="tags">
        <ul>
          <c:forEach var="tag" items="${post.tags}">
            <li><a href="${pageContext.request.contextPath}/tag/${tag.urlSlug}">${tag.name}</a></li>
          </c:forEach>
        </ul>
      </div>
      <div class="content">
        ${post.content}
      </div>
    </div>
    </c:forEach>
  </div>
  <%@include file="../general/sidebar.jsp"%>
</div>
<%@include file="../general/footer.jsp"%>