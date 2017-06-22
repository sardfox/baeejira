<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <%@include file="fragment/head.jsp" %>
</head>

<body>

	<div class="container theme-showcase" role="main">
	
		<div class="page-header">
            <h1>${pageTitle}</h1>
		</div>
		
	    <div class="row">
            <div class="col-md-6">
		        <form:form action="saveUser" modelAttribute="user" method="POST" cssClass="form-horizontal">
		            
		            <!-- need to associate this data with customer id -->
		            <form:hidden path="id" />
                    
                    <div class="form-group">
                        <form:label path="username" cssClass="control-label col-sm-2">Username:</form:label>
                        <div class="col-sm-8">
                            <form:input path="username" cssClass="form-control" required="required" />
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="email" cssClass="control-label col-sm-2">Email:</form:label>
                        <div class="col-sm-8">
                            <form:input path="email" cssClass="form-control" required="required" />
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="password" cssClass="control-label col-sm-2">Password:</form:label>
                        <div class="col-sm-8">
                            <form:password path="password" cssClass="form-control" required="required" />
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="roles" cssClass="control-label col-sm-2">Ruoli:</form:label>
                        <div class="col-sm-8">
                        <c:forEach items="${roles}" var="role">
                            <label class="checkbox-inline">
                                <form:checkbox path="roles" value="${role.id}" />${role.name}
                            </label>
                        </c:forEach>
                        </div>
                    </div>
                    
                    <button type="submit" class="btn btn-sm btn-default">Salva</button>
            
                </form:form>
            </div>
        </div>
	</div>
	
    <%@include file="fragment/bottomScripts.jsp" %>
</body>

</html>