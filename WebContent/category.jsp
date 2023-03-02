<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Category | Govt Scheme Portal</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div >
	
	<jsp:include page="header.html" />
	<div class="main-body">
	<form action="Category" class="my-form" method="get">
		<div>
			<select name="category">
				<c:forEach var="category" items="${ category_list }">
					<option>${ category }</option>
				</c:forEach>
			</select>
			<input type="submit" value="Submit" class="form-btn"/>
			
			<hr>
			
			<c:forEach var="lst" items="${ Scheme_lst }">
		
			<c:url var="templink" value="ViewScheme">
			<c:param name="id" value="${ lst[0] }"></c:param>
			</c:url>
		
			<div class="card">
                <div class="card-heading"><a href="${ templink }">[${ lst[0] }]:${ lst[1] }</a></div>
                <div class="card-date">Date : ${ lst[5] }</div>
                <div class="card-text">${lst[3]}</div>
            </div>
		</c:forEach>
		</div>
	</form>
	</div>
	<jsp:include page="footer.html" />
	
</div>
</body>
</html>