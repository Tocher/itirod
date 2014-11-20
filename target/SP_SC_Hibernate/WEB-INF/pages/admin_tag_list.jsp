<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="general/header_admin.jsp"%>
<div class="wrapper">
  <div class="add">
    <a href="${pageContext.request.contextPath}/admin/tag/add" class="new">
      Добавить тэг
    </a>
  </div>
  <table>
    <c:forEach var="tag" items="${tags}">
      <tr>
        <td>${tag.name}</td>
        <td>${tag.urlSlug}</td>
        <td><a href="/admin/tag/edit/${tag.id}">редактировать</a></td>
        <td><a href="/admin/tag/delete/${tag.id}">удалить</a></td>
      </tr>
    </c:forEach>
  </table>
</div>
<%@include file="general/footer.jsp"%>