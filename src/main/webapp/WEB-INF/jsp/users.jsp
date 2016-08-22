<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="page-wrapper">
	<div class="panel-body">
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th colspan="3">Users</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><a
							href="<spring:url value="/admin/${user.id}/profile.html"/>">
								${user.firstName} </a></td>
						<td>${user.address.suburb}</td>
						<td>${user.role.urlname}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

