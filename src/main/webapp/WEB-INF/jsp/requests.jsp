<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="page-wrapper">
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">

				<c:choose>
					<c:when test="${not empty pendingRequests}">
						<h3>All pending requests</h3>
						<table class="table table-bordered table-hover table-striped">
							<thead>

								<tr>
									<th>Request ID</th>
									<th>Address</th>
									<th>Status</th>
									<th>Action</th>
								</tr>

							</thead>
							<tbody>
								<c:forEach items="${pendingRequests}" var="pendingreq">
									<tr>
										<td>${pendingreq.id}</td>
										<td>${pendingreq.washRequest.address.formattedAddress }</td>
										<td>${pendingreq.washStatus.status}</td>
										<td><a class="btn btn-danger triggerCancel"
											href="<spring:url  value="/user/remove/washeRequest/${pendingreq.id}.html" />">
												Cancel Request </a> <a class="btn btn-warning"
											href="<spring:url  value="/request/findnearby/${pendingreq.id}.html" />">
												Find Nearby </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<h3>You have no pending requests</h3>
					</c:otherwise>
				</c:choose>

				<c:if test="${not empty doneRequests}">
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>Request History</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${doneRequests}" var="donereq">
								<tr>
									<td>${donereq.id}</td>
									<td>${donereq.washStatus.status}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</div>

