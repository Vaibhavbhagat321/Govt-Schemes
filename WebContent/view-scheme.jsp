<!DOCTYPE html>
<html>
<head>
	<title>${ lst[1] } | Govt Scheme Portal</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div>
<jsp:include page="header.html" />
<div class="main-body">
	<div class="heading">[${ lst[0] }]:${ lst[1] }</div>
	<div class="about-body">
        <div class="about-heading">Who can take Benifits?</div>
		<div class="about-text"><p style="text-align: justify;">${ lst[2] }</p></div>
        <div class="about-heading">Details</div>
    	<div class="about-text"><p style="text-align: justify;">${ lst[3] }</p></div>
    	<div class="about-heading">How to apply?</div>
		<div class="about-text"><p style="text-align: justify;">${ lst[4] }</p></div>
	</div>

</div>
<jsp:include page="footer.html" />
</div>
</body>
</html>