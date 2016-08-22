<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
    
 <sec:authorize access="isAuthenticated()">
		<div class="navbar-default sidebar" role="navigation">
		    <div class="sidebar-nav navbar-collapse">
		        <ul class="nav" id="side-menu">
		        	<sec:authorize access="hasRole('ADMIN')">
			        	<li>
			            	<a href="/admin/users.html"><i class="fa fa-dashboard fa-fw"></i> Users</a>
			            </li>
			            <li>
			            	<a href="/admin/profile.html"><i class="fa fa-dashboard fa-fw"></i> Admin Profile</a>
			            </li>
			            <li>
			            	<a href="/washerregister.html"><i class="fa fa-dashboard fa-fw"></i> Register Washer</a>
			            </li>
			            <li>
			            	<a href="/washeeregister.html"><i class="fa fa-dashboard fa-fw"></i> Register Washee</a>
			            </li>		            
					</sec:authorize>
					
					<sec:authorize access="!hasRole('ADMIN')">
			        	<li>
			                <a href="/user/dashboard.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
			            </li>
	
			        	<li>
			                <a href="/user/profile.html"><i class="fa fa-dashboard fa-fw"></i> Edit Profile</a>
			            </li> 
			        </sec:authorize>
					
		            <li>
		                <a href="/logout.html"><i class="fa fa-dashboard fa-fw"></i> Log Out</a>
		            </li>          
		            
		        </ul>
		    </div>
		</div>

	</sec:authorize>