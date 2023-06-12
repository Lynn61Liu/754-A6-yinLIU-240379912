<html>

<head>
    <title>SE754 Dev Web App</title>
</head>

<body>
<font color="red" id="failMsg">${errorMessage}</font>
<h1>CS Ed Registration</h1>
<h2>Insert an email, username and password to make an account.</h2>
<form method="post">
    Email : <input type="text" name="formEmail" id="formEmail" />
    Name : <input type="text" name="formName" id="formName" />
    Password : <input type="password" name="formPassword" id="formPassword"/>
    <input type="submit" id="formBtn" />
</form>
<font color="green" id="formMsg">${successMessage}</font>
</body>

</html>