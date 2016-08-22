<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/washeeRegForm.js"></script>

<link href="${pageContext.request.contextPath}/css/signup-form.css" rel="stylesheet">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<% final String radioBtns = "btn-primary";%>
<c:set var="radioBtns" value="<%=radioBtns%>"/>

<div id="page-wrapper">
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">
				<form:form id="washeeRegForm" commandName="washeeRegModel" cssClass="form-horizontal container">	
				
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
						<h3 class="col-sm-12">Car location</h3>
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
						<h3 class="col-sm-12">Service information</h3>
					</div>
		
					<div class="form-group">
						<label for="carType" class="col-sm-2 control-label">Car type</label>
						<div class="btn-toolbar col-sm-10" id="topic-carType" data-toggle="buttons">
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="carType" value="1" /> Sedan / Hatchback ($20-$25)
							</label>
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="carType" value="2" /> Wagon / Ute  ($25-$30)
							</label>
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="carType" value="3" /> SUV / Van ($30-$35)
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="washType" class="col-sm-2 control-label">Extras</label>
						<div class="btn-toolbar col-sm-10" id="topic-washType" data-toggle="buttons">
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="washType"  value="1" /> Interior Vacuuming (+$10)
							</label>
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="washType" value="2" />  Interior Wiping (+$10)
							</label>
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="washType" value="3" />  Both (+$20)
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="electricity" class="col-sm-2 control-label">Available electricity source</label>
						<div class="btn-toolbar col-sm-10" id="topic-electricity" data-toggle="buttons">
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="electricity" value="2" /> None
							</label>
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="electricity" value="3" /> Power point only
							</label>
							<label class="btn ${radioBtns}">
								<form:radiobutton path="electricity" value="1" /> Power point & Cable extension
							</label>
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="waterSource" class="col-sm-2 control-label">Available water source</label>
						<div class="btn-toolbar col-sm-10" id="topic-waterSource" data-toggle="buttons">
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="waterSource" value="3" /> None
							</label>
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="waterSource" value="2" /> Water tap only
							</label>			
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="waterSource" value="1" /> Water tap & Hose
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="vacuum" class="col-sm-2 control-label">Available vacuum cleaner</label>
						<div class="btn-toolbar col-sm-10" id="topic-vacuum" data-toggle="buttons">
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="vacuum" value="1" /> None
							</label>
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="vacuum" value="2" /> Cordless vacuum
							</label>
							<label class="btn ${radioBtns}" >
								<form:radiobutton path="vacuum" value="3" /> Wired vacuum
							</label>
						</div>
					</div>		
				
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">Anything else you want to share with us ? </label>
						<div class="col-sm-10">
							<form:textarea path="description" rows="5" cssClass="form-control" type="text" />
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