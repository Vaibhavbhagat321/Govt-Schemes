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
    <h2 class="heading" style="margin-top: 10px;" >Delete Scheme</h2>
    <form action="AdminPannel">
    	<input type="hidden" name="hidden" value="delete">
        <div class="form-group" style="padding-top: 0;">
            <input type="text" name="id" placeholder="Enter Scheme Id" style="width: 300px;" required>
            <input type="submit" value="Submit" class="form-btn" onclick="if(!(confirm('are you sure to delete this scheme?'))) return false">
        </div>
    </form>
    <hr>
    <div class="data-msg red">${ msg }</div>
</body>
</html>