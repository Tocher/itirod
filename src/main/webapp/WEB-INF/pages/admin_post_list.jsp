<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="general/header_admin.jsp"%>
<div class="wrapper">
  <div class="add">
    <a href="${pageContext.request.contextPath}/admin/post/add" class="new">
    Добавить пост
    </a>
  </div>
  <table>
    <c:forEach var="post" items="${posts}">
      <tr>
        <td>${post.name}</td>
        <td><a href="${pageContext.request.contextPath}/admin/post/edit/${post.id}">редактировать</a></td>
        <td><a href="${pageContext.request.contextPath}/admin/post/delete/${post.id}">удалить</a></td>
      </tr>
    </c:forEach>
  </table>
</div>
<%@include file="general/footer.jsp"%>