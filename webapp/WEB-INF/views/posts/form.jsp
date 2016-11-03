<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12">
        	<div class="panel panel-default">
	            <div class="panel-body">
	                <div class="row">
	                	<div class="col-sm-12 col-md-12">
	                		
	                		<h3>${formTitle}</h3>
	                		<hr/>
	                	
		                    <form action="${basePath}/${formAction}" method="POST" class="form">
								<c:if test="${not empty customer.id}">
									<input type="hidden" name="id" value="${customer.id}">								
								</c:if>

		                        <div class="form-group">
		                            <label for="firstname">First name: </label>
		                            <input type="text" class="form-control" name="firstname" value="${customer.firstname}">
		                        </div>
		
								<div class="form-group">
		                            <label for="lastname">Last name: </label>
		                            <input type="text" class="form-control" name="lastname" value="${customer.lastname}">
		                        </div>

		                		<div class="form-group">		                        
		                            <button type="submit" class="btn btn-success" name="submit">Save</button>		                   
		                        </div>
		                    </form>
		                </div>
	                </div>
	            </div>
	        </div>
        </div>
    </div>
</div>