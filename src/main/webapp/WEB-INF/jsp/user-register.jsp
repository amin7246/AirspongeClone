<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/signup-form.js"></script>

<form:form id="userRegForm" commandName="washerRegModel" cssClass="form-horizontal container">

	<c:if test="${param.success eq true}"> 
	
		<div class="alert alert-success">Registration Successful!</div>
	
	</c:if>
	<div class="form-group">
		<h3 class="col-sm-12">Personal information</h3>
	</div>
	<div class="form-group">
		<label for="firstName" class="col-sm-2 control-label">First
			Name</label>
		<div class="col-sm-8">
			<form:input path="firstName" cssClass="form-control" type="text"/>
		</div>
	</div>
	<div class="form-group">
		<label for="lastName" class="col-sm-2 control-label">Last Name</label>
		<div class="col-sm-8">
			<form:input path="lastName" cssClass="form-control" type="text"/>
		</div>
	</div>
	<div class="form-group">
		<label for="Email" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-8">
			<form:input path="email" cssClass="form-control" type="text"/>
		</div>
	</div>
	<div class="form-group">
		<label for="Password" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-8">
			<form:input path="password" cssClass="form-control" type="password"/>
		</div>
	</div>
	<div class="form-group">
		<label for="confirmPassword" class="col-sm-2 control-label">Confirm Password</label>
		<div class="col-sm-8">
			<input class="form-control" type="password"/>
		</div>
	</div>
	<div class="form-group">
		<label for="phone" class="col-sm-2 control-label">Phone number</label>
		<div class="col-sm-8">
			<form:input path="phone" cssClass="form-control" type="text"/>
		</div>
	</div>

	<div class="form-group">
		<h3 class="col-sm-12">Address</h3>
	</div>

	<div class="form-group">
		<label for="add1" class="col-sm-2 control-label">Address Line 1</label>
		<div class="col-sm-8">
			<form:input path="addressLine1" cssClass="form-control" type="text"/>
		</div>
	</div>
	<div class="form-group">
		<label for="add2" class="col-sm-2 control-label">Address Line 2</label>
		<div class="col-sm-8">
			<form:input path="addressLine2" cssClass="form-control" type="text"/>
		</div>
	</div>
	<div class="form-group">
		<label for="city" class="col-sm-2 control-label">City</label>
		<div class="col-sm-3">
			<form:input path="city" cssClass="form-control" type="text"/>
		</div>
		
		<label for="postcode" class="col-sm-2 control-label">Post code</label>
		<div class="col-sm-3">
			<form:input path="postcode" cssClass="form-control" type="text"/>
		</div>
	</div>
	
	<div class="form-group">
		<h3 class="col-sm-12">Bank account details</h3>
	</div>

	<div class="form-group">
		<label for="bankname" class="col-sm-2 control-label">Bank Name</label>
		<div class="col-sm-8">
			<form:input path="bankName" cssClass="form-control" type="text"/>
		</div>
	</div>
	<div class="form-group">
		<label for="bsb" class="col-sm-2 control-label">BSB</label>
		<div class="col-sm-3">
			<form:input path="bsb" cssClass="form-control" type="text"/>
		</div>
		
		<label for="accNo" class="col-sm-2 control-label">Account Number</label>
		<div class="col-sm-3">
			<form:input path="accountNumber" cssClass="form-control" type="text"/>
		</div>
	</div>
	
	<div class="form-group">
		<label for="accholder" class="col-sm-2 control-label">Account Holder</label>
		<div class="col-sm-8">
			<form:input path="accountHolder" cssClass="form-control" type="text"/>
		</div>
	</div>
	
	<br/>
	
	<div class="form-group">
		<label class="col-sm-12">How far are you willing to go?</label>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<label class="checkbox-inline">
			  <input type="radio" id="inlineCheckbox1" value="option1"> 1 Km
			</label>
			<label class="checkbox-inline">
			  <input type="radio" id="inlineCheckbox2" value="option2"> 3 Km
			</label>
			<label class="checkbox-inline">
			  <input type="radio" id="inlineCheckbox3" value="option3"> 5 Km
			</label>
			<label class="checkbox-inline">
			  <input type="radio" id="inlineCheckbox3" value="option3"> 10 Km
			</label>
			<label class="checkbox-inline">
			  <input type="radio" id="inlineCheckbox3" value="option3"> 15 Km
			</label>
			<label class="checkbox-inline">
			  <input type="radio" id="inlineCheckbox3" value="option3"> 25 Km
			</label>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-12">Do you have a cordless vacuum?</label>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<label class="radio-inline" >
			  <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> Yes
			</label>
			<label class="radio-inline">
			  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> No
			</label>
		</div>
	</div>
	
	<br/>
	
	<div class="col-sm-offset-3  col-sm-6">
		<p>
			<strong>By clicking Save I accept 
				<a href="http://www.airsponge.com.au/terms-conditions" target="_blank">Terms &amp; Conditions</a>
				of using this service.
			</strong>
		</p>
	</div>


	<div class="form-group">
		<div class="col-sm-offset-5  col-sm-2">
			<input type="submit" value="Save" class="btn btn-lg btn-primary"/>
		</div>
	</div>
</form:form>