<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/washerRegForm.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-slider.js"></script>

<link href="${pageContext.request.contextPath}/css/bootstrap-slider.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/signup-form.css" rel="stylesheet">

<div id="page-wrapper">
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">
			    <form:form id="washerRegForm" commandName="washeeRegModel" cssClass="form-horizontal container">

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
						<div class="col-sm-10">
							<form:input value="${pageUser.phone}" path="phone" cssClass="form-control" type="text"/>
						</div>
					</div>
				
					<div class="form-group">
						<h3 class="col-sm-12">Address</h3>
					</div>
				
					<div class="form-group">
						<label for="addressLine1" class="col-sm-2 control-label">Street Address</label>
						<div class="col-sm-10">
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
					
					<div class="form-group">
						<h3 class="col-sm-12">Bank account details</h3>
					</div>
				
					<div class="form-group">
						<label for="bankName" class="col-sm-2 control-label">Bank Name</label>
						<div class="col-sm-10">
							<form:input value="${pageUser.bankAccount.bankName}" path="bankName" cssClass="form-control" type="text"/>
						</div>
					</div>
					<div class="form-group">
						<label for="bsb" class="col-sm-2 control-label">BSB</label>
						<div class="col-sm-4">
							<form:input value="${pageUser.bankAccount.bsb}" path="bsb" cssClass="form-control" type="text"/>
						</div>
						
						<label for="accountNumber" class="col-sm-2 control-label">Account Number</label>
						<div class="col-sm-4">
							<form:input value="${pageUser.bankAccount.accountNumber}" path="accountNumber" cssClass="form-control" type="text"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="accountHolder" class="col-sm-2 control-label">Account Holder</label>
						<div class="col-sm-10">
							<form:input value="${pageUser.bankAccount.accountHolder}" path="accountHolder" cssClass="form-control" type="text"/>
						</div>
					</div>
					
					<br/>
					<div class="form-group">
						<label class="col-sm-3 control-label">Do you have a cordless vacuum?</label>
						<div class="btn-toolbar col-sm-9" data-toggle="buttons">
							<c:choose>
								<c:when test="${pageWasher.hasVacuum eq true}">
									<label class="btn btn-primary active" >
										<form:radiobutton path="washerHasVacuume" value="true" checked=""/> Yes
									</label>
								</c:when>
								<c:otherwise>
									<label class="btn btn-primary" >
										<form:radiobutton path="washerHasVacuume" value="true"/> Yes
									</label>
								</c:otherwise>
							</c:choose>
							
							<c:choose>
								<c:when test="${pageWasher.hasVacuum eq false}">
									<label class="btn btn-primary active" >
										<form:radiobutton path="washerHasVacuume" value="false" checked=""/> No
									</label>
								</c:when>
								<c:otherwise>
									<label class="btn btn-primary" >
										<form:radiobutton path="washerHasVacuume" value="false"/> No
									</label>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">How far are you willing to go? (KM)</label>
				
						<div class="col-sm-4">
							<div class="input-group">
								<span class="input-group-addon"><b>1</b></span>
								<form:input path="travelDistance"
									id="distanceSlider"
									data-slider-id='distanceSlider'
									type="number" 
									data-slider-min="1" 
									data-slider-max="25" 
									data-slider-step="1" 
									data-slider-value="${pageWasher.travelDistance}"
								/>
								<span class="input-group-addon"><b>25</b></span>
							</div>
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
   