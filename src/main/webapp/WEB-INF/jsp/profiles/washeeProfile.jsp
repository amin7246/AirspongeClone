<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/washeeRegForm.js"></script>

<link href="${pageContext.request.contextPath}/css/signup-form.css" rel="stylesheet">

<div id="page-wrapper">
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">
			    <form:form id="washeeRegForm" commandName="washeeRegModel" cssClass="form-horizontal container">

					<c:if test="${param.success eq true}"> 
					
						<div class="alert alert-success">Update Successful!</div>
					
					</c:if>

					<div class="form-group">
						<h3 class="col-sm-12">Personal information</h3>
					</div>
					<div class="form-group">
						<label for="firstName" class="col-sm-2 control-label">First Name</label>
						<div class="col-sm-10">
							<form:input value="${pageUser.firstName}" path="firstName" cssClass="form-control" type="text"/>
						</div>
					</div>
					<div class="form-group">
						<label for="lastName" class="col-sm-2 control-label">Last Name</label>
						<div class="col-sm-10">
							<form:input value="${pageUser.lastName}" path="lastName" cssClass="form-control" type="text"/>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-2 control-label">Phone number</label>
						<div class="col-sm-8">
							<form:input value="${pageUser.phone}" path="phone" cssClass="form-control" type="text"/>
						</div>
					</div>
				
					<div class="form-group">
						<h3 class="col-sm-12">Address</h3>
					</div>
				
					<div class="form-group">
						<label for="addressLine1" class="col-sm-2 control-label">Street Address</label>
						<div class="col-sm-8">
							<form:input value="${pageUser.address.addressLine1}" path="addressLine1" cssClass="form-control" type="text"/>
						</div>
					</div>
					<div class="form-group">
						<label for="suburb" class="col-sm-2 control-label">Suburb</label>
						<div class="col-sm-4">
							<form:input value="${pageUser.address.suburb}" path="suburb" cssClass="form-control" type="text"/>
						</div>
						
						<label for="postcode" class="col-sm-2 control-label">Post code</label>
						<div class="col-sm-4">
							<form:input value="${pageUser.address.postcode}" path="postcode" cssClass="form-control" type="text"/>
						</div>
					</div>
					
					<br/>			
				
					<div class="form-group">
						<div class="col-sm-offset-5  col-sm-2">
							<input type="submit" value="Save" class="btn btn-lg btn-primary"/>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>