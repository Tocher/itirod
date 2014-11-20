<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="general/header_admin.jsp"%>
<div class="wrapper">
  <div class="add">
    <a href="${pageContext.request.contextPath}/admin/post/add" class="new">
      Добавить комментарий
    </a>
  </div>
  <table>
    <c:forEach var="comment" items="${comments}">
      <tr>
        <td>${comment.name}</td>
        <td>${comment.content}</td>
        <td><a href="/admin/comment/edit/${comment.id}">редактировать</a></td>
        <td><a href="/admin/comment/delete/${comment.id}">удалить</a></td>
      </tr>
    </c:forEach>
  </table>
</div>
<%@include file="general/footer.jsp"%>