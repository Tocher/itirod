<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="general/header_admin.jsp"%>
<div class="wrapper">
  <form:form method="POST" commandName="tag" action="${pageContext.request.contextPath}/admin/tag/edit/${tag.id}">
    <table>
      <tbody>
      <tr>
        <td>Name:</td>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td>urlSlug:</td>
        <td><form:input path="urlSlug" /></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Изменить" /></td>
      </tr>
      </tbody>
    </table>
  </form:form>
</div>
<%@include file="general/footer.jsp"%>