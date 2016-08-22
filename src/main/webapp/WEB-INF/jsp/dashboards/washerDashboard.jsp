<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="page-wrapper">
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">
				
				<c:choose>
					<c:when test="${not empty pendingRequests}">
						<h3>Your upcoming jobs</h3>
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>Request ID</th>
									<th>location</th>
									<th>Action</th>
								</tr>
							
							</thead>
							<tbody>
								<c:forEach items="${pendingRequests}" var="pendingreq"> 
									<tr>
										<td>
											${pendingreq.id}
										</td>
										<td>
											${pendingreq.washStatus.status}
										</td>
										<td>
										<a class="btn btn-danger" href="<spring:url  value="/user/jobs/washerCancelRequest/${pendingreq.id}.html" />" > Cancel Job </a>
									
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<h3>You have no job waiting for you!</h3>
					</c:otherwise>
				</c:choose>
		
		<c:choose>
					<c:when test="${not empty availableRequests}">
						<h3>All Available jobs around you </h3>
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>Request ID</th>
									<th>location</th>
									<th>Action</th>
								</tr>
							
							</thead>
							<tbody>
								<c:forEach items="${availableRequests}" var="availablereq"> 
									<tr>
										<td>
											${availablereq.id}
										</td>
										<td>
											${availablereq.washStatus.status}
										</td>
										<td>
										<a class="btn btn-success" href="<spring:url  value="/user/jobs/washerRequest/${availablereq.id}.html" />" > I WANT THIS JOB! </a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<h3>You have no available job around you</h3>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${not empty doneRequests}">
						<h3>Your Job History </h3>
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>Request ID</th>
									<th>location</th>
									<th>Action</th>
								</tr>
							
							</thead>
							<tbody>
								<c:forEach items="${doneRequests}" var="donereq"> 
									<tr>
										<td>
											${donereq.id}
										</td>
										<td>
											${donereq.washStatus.status}
										</td>
										<td>
										
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<h3>You have no Done Jobs</h3>
					</c:otherwise>
				</c:choose>
				
			</div>
		</div>
	</div>
</div>