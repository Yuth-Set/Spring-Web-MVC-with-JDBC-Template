    <%@ include file="../includes/header.jsp" %>
    <% 
    	String keyword = request.getParameter("key");
    	if (keyword == "null" || keyword == null) {
    		keyword = "";
    	}
    %>
    <div class="container">
		<div class="row">
			<div class="col-sm-10 col-md-10 text-left">
				<form role="search" action="${basePath}/search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Enter keywork here..." name="key" value="<%= keyword %>">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
						</div>
					</div>
				</form>
			</div>
			
			<div class="col-sm-2 col-md-2 text-right">
				<a href="${basePath}/create" class="btn btn-primary">New Post</a>
			</div>
		</div>
		<hr/>
		<table class="table table-bordered">
			<tr>
				<th class="text-center" width="5%">ID</th>
				<th class="text-center" width="40%">First name</th>
				<th class="text-center" width="40%">Last name</th>
				<th class="text-center" width="15%">Action</th>
			</tr>
			<c:forEach items="${listCustomer}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.firstname}</td>
					<td>${customer.lastname}</td>
					<td class="text-center">
						<form action="${basePath}/delete/${customer.id}" method="POST">
							<a href="${basePath}/update/${customer.id}" class="btn btn-sm btn-primary">Update</a>
							&nbsp;
							<button type="submit" class="btn btn-sm btn-danger" name="submit">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
<%@ include file="../includes/footer.jsp" %>