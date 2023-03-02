<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Log-In Admin | Govt Scheme Portal</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div>
	<jsp:include page="header.html" />
	
	<div class="main-body">
            <form action="AdminVerfication" method="post" class="admin-form">
                <div><h2>Admin Login</h2></div>
                <div>
                    <label class="form-label">Username</label>
                    <input type="text" name="username" class="admin-input" required>
                </div>
                <div>
                    <label class="form-label">Password</label>
                    <input type="password" name="password" class="admin-input" required>
                    
					<label class="err-msg">${ msg }</label>
                    
                </div>
                <div>
                    <input type="submit" value="Log-In" class="form-btn">
                </div>
            </form>
        </div>
	
	<jsp:include page="footer.html"/>
</div>
</body>
</html>