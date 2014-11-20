<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="general/header.jsp"%>
<div class="wrapper">
	<div class="left">
			<br /> Введите логин и пароль. <br /> <span
				style="color: red">${message}</span> <br />
			<form:form method="post" action="j_spring_security_check"
				modelAttribute="users">
				<table>
					<tr>
						<td>Логин:</td>
						<td><form:input path="username" /></td>
					</tr>
					<tr>
						<td>Пароль:</td>
						<td><form:input path="password" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Войти" /></td>
					</tr>
				</table>
			</form:form>
	</div>
</div>
<%@include file="general/footer.jsp"%>