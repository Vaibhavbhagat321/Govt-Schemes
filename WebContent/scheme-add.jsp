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
    <form action="AdminPannel">
    <input type="hidden" name="hidden" value="add">
        <h2 class="heading" style="margin-top: 10px;" >Add Scheme</h2>
        <table>
        <tr><td>
        <div class="form-group">
            <label>Scheme Name:<span class="mandatory">*</span></label>
            <input type="text" name="sname" style="width: 300px;" required>
        </div></td><td>
        <div class="form-group">
            <label>Scheme Benifits:<span class="mandatory">*</span></label>
            <select name="sbenifit"  style="width: 300px;" required>
                <option>Elementary Education</option>
                <option>Secondary Education</option>
                <option>Higher Education</option>
            </select>
        </div>
        </td>
        </tr>
        <tr><td>
        <div class="form-group">
            <label>Scheme details:<span class="mandatory">*</span></label>
            <textarea name="sdetails"  cols="30" rows="3"  style="width: 300px;" required></textarea>
        </div></td><td>
        <div class="form-group">
            <label>Scheme Apply:<span class="mandatory">*</span></label>
            <textarea name="sapply"  cols="30" rows="3"  style="width: 300px;" required></textarea>
        </div>
    </td>
        </tr>
        </table>
        <input type="submit" value="Submit" class="form-btn">
    </form>
    <hr>
    <div class="data-msg red">${ msg }</div>
</body>
</html>