
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<body>	
	<% 
		String currentPath = (String) request.getAttribute("currentPath"); 
		String fullPath = (String) request.getRequestURI();
	%>
	<c:set var="basePath" value="pageContext.request.contextPath"></c:set>
	<c:set var="basePath" value="/SpringWebAppJdbc"></c:set>
    <div class="container">
    	<nav class="navbar navbar-default ">
	        <div class="container-fluid">
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${basePath}/">Spring</a>
	            </div>
	            <ul class="nav navbar-nav">
	                <li class="<%= fullPath.contains("home/index") ? "active" : "" %>"><a href="${basePath}/">Home</a></li>
	            </ul>
	        </div>
	    </nav>
    </div>