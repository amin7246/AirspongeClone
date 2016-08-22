<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script
	src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/washeeRegForm.js"></script>

<link href="${pageContext.request.contextPath}/css/signup-form.css"
	rel="stylesheet">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	final String radioBtns = "btn-primary";
%>
<c:set var="radioBtns" value="<%=radioBtns%>" />

<script type="text/javascript">
	$(document).ready(
			function() {

				$(".triggerCancel").click(
						function(e) {
							e.preventDefault();
							$("#modelCancel .canceleReqBtn").attr("href",
									$(this).attr("href"));
							$("#modelCancel").modal();
						})
			});
</script>

<div id="page-wrapper">
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">

				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#myModal">Request a new
					Wash</button>

				<c:choose>
					<c:when test="${not empty pendingRequests}">
						<h3>Your pending requests</h3>
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
												Cancel Request </a></td>
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

<div class="modal fade" id="modelCancel" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Cancel Request</h4>
			</div>

			<div class="modal-body">Are you sure about canceling the
				request?</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">No,
					Go back!</button>
				<a class="btn btn-danger canceleReqBtn" href="">Yes, Cancel the
					Request </a>
			</div>
		</div>
	</div>
</div>

<form:form id="washeeRegForm" commandName="washeeRegModel"
	cssClass="form-horizontal container">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Make a request</h4>
				</div>

				<div class="modal-body">

					<div class="form-group">
						<h3 class="col-sm-12">Car location</h3>
					</div>

					<div class="form-group">
						<label for="addressLine1" class="col-sm-2 control-label">Street
							Address</label>
						<div class="col-sm-8">
							<form:input path="addressLine1" cssClass="form-control"
								type="text" />
						</div>
					</div>
					<div class="form-group">
						<label for="suburb" class="col-sm-2 control-label">Suburb</label>
						<div class="col-sm-3">
							<form:input path="suburb" cssClass="form-control" type="text" />
						</div>

						<label for="postcode" class="col-sm-2 control-label">Post
							code</label>
						<div class="col-sm-3">
							<form:input path="postcode" cssClass="form-control" type="text" />
						</div>
					</div>

					<div class="form-group">
						<h3 class="col-sm-12">Additional information</h3>
					</div>

					<div class="form-group">
						<label for="carType" class="col-sm-3 control-label">Car
							type</label>
						<div class="btn-toolbar col-sm-7" id="topic-carType"
							data-toggle="buttons">
							<label class="btn ${radioBtns}"> <form:radiobutton
									path="carType" value="1" /> Sedan / Hatchback
							</label> <label class="btn ${radioBtns}"> <form:radiobutton
									path="carType" value="2" /> Wagon / Ute
							</label> <label class="btn ${radioBtns}"> <form:radiobutton
									path="carType" value="3" /> SUV / Van
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="washType" class="col-sm-3 control-label">Extras</label>
						<div class="btn-toolbar col-sm-7" id="topic-washType"
							data-toggle="buttons">
							<label class="btn ${radioBtns}"> <form:radiobutton
									path="washType" value="1" /> Interior Vacuuming (+$10)
							</label> <label class="btn ${radioBtns}"> <form:radiobutton
									path="washType" value="2" /> Interior Wiping (+$10)
							</label> <label class="btn ${radioBtns}"> <form:radiobutton
									path="washType" value="3" /> Both (+$20)
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="electricity" class="col-sm-3 control-label">Available
							electricity source</label>
						<div class="btn-toolbar col-sm-7" id="topic-electricity"
							data-toggle="buttons">
							<label class="btn ${radioBtns}"> <form:radiobutton
									path="electricity" value="2" /> None
							</label> <label class="btn ${radioBtns}"> <form:radiobutton
									path="electricity" value="3" /> Power point only
							</label> <label class="btn ${radioBtns}"> <form:radiobutton
									path="electricity" value="1" /> Power point & Cable extension
							</label>
						</div>
					</div>


					<div class="form-group">
						<label for="waterSource" class="col-sm-3 control-label">Available
							water source</label>
						<div class="btn-toolbar col-sm-7" id="topic-waterSource"
							data-toggle="buttons">
							<label class="btn ${radioBtns}"> <form:radiobutton
									path="waterSource" value="3" /> None
							</label> <label class="btn ${radioBtns}"> <form:radiobutton
									path="waterSource" value="2" /> Water tap only
							</label> <label class="btn ${radioBtns}"> <form:radiobutton
									path="waterSource" value="1" /> Water tap & Hose
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="vacuum" class="col-sm-3 control-label">Available
							vacuum cleaner</label>
						<div class="btn-toolbar col-sm-7" id="topic-vacuum"
							data-toggle="buttons">
							<label class="btn ${radioBtns}"> <form:radiobutton
									path="vacuum" value="1" /> None
							</label> <label class="btn ${radioBtns}"> <form:radiobutton
									path="vacuum" value="2" /> Cordless vacuum
							</label> <label class="btn ${radioBtns}"> <form:radiobutton
									path="vacuum" value="3" /> Wired vacuum
							</label>
						</div>
					</div>
					<br />

					<div class="col-sm-offset-3 col-sm-6">
						<p>
							<strong>By clicking Register I accept <a
								href="http://www.airsponge.com.au/terms-conditions"
								target="_blank">Terms &amp; Conditions</a> of using this
								service.
							</strong>
						</p>
					</div>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" value="Save" class="btn btn-lg btn-success" />
				</div>

			</div>
		</div>
	</div>

</form:form>




