<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
				<form:form id="washerRegForm" commandName="washerRegModel" cssClass="form-horizontal container">
				
					<c:if test="${param.success eq true}"> 
					
						<div class="alert alert-success">Registration Successful!</div>
					
					</c:if>

					<div class="form-group">
						<h3 class="col-sm-12">Personal information</h3>
					</div>
					<div class="form-group">
						<label for="firstName" class="col-sm-2 control-label">First Name</label>
						<div class="col-sm-10">
							<form:input path="firstName" cssClass="form-control" type="text"/>
						</div>
					</div>
					<div class="form-group">
						<label for="lastName" class="col-sm-2 control-label">Last Name</label>
						<div class="col-sm-10">
							<form:input path="lastName" cssClass="form-control" type="text"/>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<form:input path="email" cssClass="form-control" type="text"/>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<form:input path="password" cssClass="form-control" type="password"/>
						</div>
					</div>
					<div class="form-group">
						<label for="confirmPassword" class="col-sm-2 control-label">Confirm Password</label>
						<div class="col-sm-10">
							<input class="form-control" type="password"/>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-2 control-label">Phone number</label>
						<div class="col-sm-10">
							<form:input path="phone" cssClass="form-control" type="text"/>
						</div>
					</div>
				
					<div class="form-group">
						<h3 class="col-sm-12">Address</h3>
					</div>
				
					<div class="form-group">
						<label for="addressLine1" class="col-sm-2 control-label">Street Address</label>
						<div class="col-sm-10">
							<form:input path="addressLine1" cssClass="form-control" type="text"/>
						</div>
					</div>
					<div class="form-group">
						<label for="suburb" class="col-sm-2 control-label">Suburb</label>
						<div class="col-sm-4">
							<form:input path="suburb" cssClass="form-control" type="text"/>
						</div>
						
						<label for="postcode" class="col-sm-2 control-label">Post code</label>
						<div class="col-sm-4">
							<form:input path="postcode" cssClass="form-control" type="text"/>
						</div>
					</div>
					
					<div class="form-group">
						<h3 class="col-sm-12">Bank account details</h3>
					</div>
				
					<div class="form-group">
						<label for="bankName" class="col-sm-2 control-label">Bank Name</label>
						<div class="col-sm-10">
							<form:input path="bankName" cssClass="form-control" type="text"/>
						</div>
					</div>
					<div class="form-group">
						<label for="bsb" class="col-sm-2 control-label">BSB</label>
						<div class="col-sm-4">
							<form:input path="bsb" cssClass="form-control" type="text"/>
						</div>
						
						<label for="accountNumber" class="col-sm-2 control-label">Account Number</label>
						<div class="col-sm-4">
							<form:input path="accountNumber" cssClass="form-control" type="text"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="accountHolder" class="col-sm-2 control-label">Account Holder</label>
						<div class="col-sm-10">
							<form:input path="accountHolder" cssClass="form-control" type="text"/>
						</div>
					</div>
					
					<div class="form-group">
						<h3 class="col-sm-12">Additional information</h3>
					</div>
					
					<div class="form-group">
						<label for="washerHasVacuume" class="col-sm-3 control-label">Do you have a cordless vacuum?</label>
						<div class="btn-toolbar col-sm-9" id="topic-hasVacuum" data-toggle="buttons">
							<label class="btn btn-primary" >
								<form:radiobutton path="washerHasVacuume" value="true" /> Yes
							</label>
							<label class="btn btn-primary">
								<form:radiobutton path="washerHasVacuume" value="false" />  No
							</label>
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
									data-slider-value="15"
								/>
								<span class="input-group-addon"><b>25</b></span>
							</div>
						</div>
					</div>
					
					
					<br/>
					
					<div class="col-sm-offset-3 col-sm-6">
						<p>
							<strong>By clicking Register I accept 
								<a href="http://www.airsponge.com.au/terms-conditions" target="_blank">Terms &amp; Conditions</a>
								of using this service.
							</strong>
						</p>
					</div>
				
				
					<div class="form-group">
						<div class="col-sm-offset-5 col-sm-2">
							<input type="submit" value="Register" class="btn btn-lg btn-success"/>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
