<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Govt Scheme Portal</title>
	<link rel="stylesheet" href="css/style.css">
</head>	
<body >
<div >
	
	<jsp:include page="header.html" />
	
	<div class="main-body">
	
		<div class="heading">Recent Updates</div>
		
		<c:forEach var="lst" items="${ schemes }">
		
		<c:url var="templink" value="ViewScheme">
		<c:param name="id" value="${ lst[0] }"></c:param>
		</c:url>
		
			<div class="card">
                <div class="card-heading"><a href="${ templink }">[${ lst[0] }]:${ lst[1] }</a></div>
                <div class="card-date">Date : ${ lst[5] }</div>
                <div class="card-text" style="text-align: justify;">${lst[3]}</div>
            </div>
		</c:forEach>
	</div>
	<jsp:include page="footer.html" />
</div>
</body>
</html>