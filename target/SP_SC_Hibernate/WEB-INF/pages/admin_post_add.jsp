<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="general/header_admin.jsp"%>
<div class="wrapper">
  <form:form method="POST" commandName="post" action="${pageContext.request.contextPath}/admin/post/add">
    <div class="left">
      <table>
        <tbody>
        <tr>
          <td>Заголовок:</td>
          <td><form:input path="name" /></td>
        </tr>
        <tr>
          <td>Краткое описание:</td>
          <td><form:textarea path="content" /></td>
        </tr>
        <tr>
          <td>Полное описание:</td>
          <td><form:textarea path="contentFull" /></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" value="Добавить" /></td>
        </tr>
        </tbody>
      </table>
    </div>
    <div class="right">
      <h2>Тэги</h2>
      <form:select path="tags">
        <c:forEach var="tag" items="${tags}">
          <form:option value="${tag.id}">${tag.name}</form:option>
        </c:forEach>
      </form:select>
    </div>
  </form:form>
</div>
<%@include file="general/footer.jsp"%>