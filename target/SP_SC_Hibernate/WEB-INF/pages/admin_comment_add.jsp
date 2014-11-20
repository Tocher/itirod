<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="general/header_admin.jsp"%>
<div class="wrapper">
  <form:form method="POST" commandName="comment" action="${pageContext.request.contextPath}/admin/comment/add">
    <table>
      <tbody>
      <tr>
        <td>Name:</td>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td>Content:</td>
        <td><form:textarea path="content" /></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Добавить" /></td>
      </tr>
      </tbody>
    </table>
  </form:form>
</div>
<%@include file="general/footer.jsp"%>