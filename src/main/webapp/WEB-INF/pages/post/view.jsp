<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../general/header.jsp"%>
<div class="wrapper">
  <div class="left">
    <div class="post">
      <%@include file="post.jsp"%>
      <div class="content">
          ${post.contentFull}
      </div>
    </div>
    <div class="comments">
      <c:forEach var="commentitem" items="${post.comments}">
          <div class="comment">
              <div class="name">${commentitem.name} | <fmt:formatDate value="${commentitem.date}" pattern="dd.MM.yyyy" /></div>
              <div class="msg">${commentitem.content}</div>
          </div>
      </c:forEach>
        <form:form method="POST" commandName="comment" action="${pageContext.request.contextPath}/comment/add/${post.id}">
        <table class="commentForm">
            <tbody>
            <tr>
                <td>Ваше имя:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Комментарий:</td>
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
  </div>
  <%@include file="../general/sidebar.jsp"%>
</div>
<%@include file="../general/footer.jsp"%>