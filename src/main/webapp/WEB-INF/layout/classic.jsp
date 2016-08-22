<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
	integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"
	integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/classic.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/sb-admin-2.js"></script>
<link href="${pageContext.request.contextPath}/css/sb-admin-2.css"
	rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>

</head>
<body>
	<nav class="navbar navbar-default navbar-static-top" role="navigation"
		style="margin-bottom: 0">
		<div class="navbar-header">
			<div class="container">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" rel="home" href="/index.html"
					title="AirSponge"> <img
					src="${pageContext.request.contextPath}/img/logo.png">
				</a>
				<div class="nav navbar-top-links navbar-right"></div>
			</div>
		</div>
	</nav>

	<sec:authorize access="isAuthenticated()">
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<sec:authorize access="hasRole('ADMIN')">
						<li><a href="/admin/users.html"><i
								class="fa fa-dashboard fa-fw"></i> Users</a></li>
						<li><a href="/admin/requests.html"><i
								class="fa fa-dashboard fa-fw"></i> Requests</a></li>
						<li><a href="/admin/profile.html"><i
								class="fa fa-dashboard fa-fw"></i> Admin Profile</a></li>
						<li><a href="/washerregister.html"><i
								class="fa fa-dashboard fa-fw"></i> Register Washer</a></li>
						<li><a href="/washeeregister.html"><i
								class="fa fa-dashboard fa-fw"></i> Register Washee</a></li>
					</sec:authorize>

					<sec:authorize access="!hasRole('ADMIN')">
						<li><a href="/user/dashboard.html"><i
								class="fa fa-dashboard fa-fw"></i> Dashboard</a></li>

						<li><a href="/user/profile.html"><i
								class="fa fa-dashboard fa-fw"></i> Edit Profile</a></li>


						<li><a href="/user/changepassword.html"><i
								class="fa fa-dashboard fa-fw"></i> Change Password</a></li>
					</sec:authorize>

					<li><a href="/logout.html"><i
							class="fa fa-dashboard fa-fw"></i> Log Out</a></li>

				</ul>
			</div>
		</div>

	</sec:authorize>
	
	
	<div>
		<tiles:insertAttribute name="body" />
	</div>

	<center>
		<tiles:insertAttribute name="footer" />
	</center>
</body>
</html>