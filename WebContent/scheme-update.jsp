<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript">
        window.history.forward();
        function noBack(){
            window.history.forward();
        }
    </script>
</head>
<body>
    <h2 class="heading" style="margin-top: 10px;" >Update Scheme</h2>
    <form action="AdminPannel">
    <input type="hidden" name="hidden" value="updatesearch">
        <div class="form-group" style="padding-top: 0;">
        	<c:choose>
            	<c:when test="${ lst[0] > 1000 }">
            		<input type="text" name="id" disabled="disabled" placeholder="Enter Scheme Id" value="${ lst[0] }" style="width: 300px;" required>	
            	</c:when>
            	<c:otherwise>
            		<input type="text" name="id" placeholder="Enter Scheme Id" style="width: 300px;" required>
            	</c:otherwise>
            </c:choose>
            <input type="submit" value="Submit" class="form-btn">
        </div>
    </form>
    <hr>
	<div class="data-msg red">${ msg }</div>

    <form action="AdminPannel">
    <input type="hidden" name="id" value="${ lst[0] }">
    <input type="hidden" name="hidden" value="update">
        <table>
        <tr><td>
        <div class="form-group">
            <label>Scheme Name:<span class="mandatory">*</span></label>
            <input type="text" name="sname" value="${ lst[1] }" style="width: 300px;"  required>
        </div></td><td>
        <div class="form-group">
            <label>Scheme Benifits:<span class="mandatory">*</span></label>
            <select name="sbenifit" style="width: 300px;" required>
                <c:choose>
                	<c:when test="${ lst[2] == 'Elementary Education' }">
                		<option selected>Elementary Education</option>	
                	</c:when>
                	<c:otherwise>
                		<option>Elementary Education</option>
                	</c:otherwise>
                </c:choose>
                <c:choose>
                	<c:when test="${ lst[2] == 'Secondary Education' }">
                		<option selected>Secondary Education</option>	
                	</c:when>
                	<c:otherwise>
                		<option>Secondary Education</option>
                	</c:otherwise>
                </c:choose>
                <c:choose>
                	<c:when test="${ lst[2] == 'Higher Education' }">
                		<option selected>Higher Education</option>	
                	</c:when>
                	<c:otherwise>
                		<option>Higher Education</option>
                	</c:otherwise>
                </c:choose>
            </select>
        </div>
        </td>
        </tr>
        <tr><td>
        <div class="form-group">
            <label>Scheme details:<span class="mandatory">*</span></label>
            <textarea name="sdetails"  cols="30" rows="3" style="width: 300px;">${ lst[3] }</textarea>
        </div></td><td>
        <div class="form-group">
            <label>Scheme Apply:<span class="mandatory">*</span></label>
            <textarea name="sapply"  cols="30" rows="3" style="width: 300px;">${ lst[4] }</textarea>
        </div>
    </td>
        </tr>
        </table>
        <input type="submit" value="Submit" class="form-btn">
    </form>
    <hr>
    <div class="data-msg red">${ msg1 }</div>
</body>
</html>