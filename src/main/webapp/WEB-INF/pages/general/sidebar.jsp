<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="right">
  <h2>Рубрики</h2>
  <ul class="right_tags">
    <c:forEach var="tag" items="${tags}">
      <li><a href="${pageContext.request.contextPath}/tag/${tag.urlSlug}">${tag.name}</a></li>
    </c:forEach>
  </ul>
</div>