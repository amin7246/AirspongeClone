<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/passwordChangeForm.js"></script>

<link href="${pageContext.request.contextPath}/css/signup-form.css" rel="stylesheet">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="page-wrapper">
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">
				<form:form id="passwordChangeForm" commandName="changePassModel" cssClass="form-horizontal container">	
				
					<c:if test="${param.success eq true}"> 
						<div class="alert alert-success">Your password has been changed successfully!</div>
					</c:if>
					
					<c:if test="${param.success eq false}"> 
						<div class="alert alert-warning">Current password is not Correct!</div>
					</c:if>
					
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">Current Password</label>
						<div class="col-sm-10">
							<form:input path="currentPassword" cssClass="form-control" type="password"/>
						</div>
					</div>
				
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">New Password</label>
						<div class="col-sm-10">
							<form:input path="newPassword" cssClass="form-control" type="password"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">Confirm New Password</label>
						<div class="col-sm-10">
							<form:input path="confirmNewPassword" cssClass="form-control" type="password"/>
						</div>
					</div>
			
					
					<div class="form-group">
						<div class="col-sm-offset-5 col-sm-2">
							<input type="submit" value="Change Password" class="btn btn-lg btn-success"/>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>