<%@page import="model.User" %>
<%@page import="ctrl.Controller" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<form name="frm_index" action="Controller" method="post">
    <div style="color: #ff0000;">${errorMessage}</div>
    <label> Login : </label> <input type="text" name="loginForm"/><br/>
    <label> Password : </label> <input type="text" name="passForm"/> <br/>
    <input type="submit" name="buttonSubmit" value="Send"/>
</form>

</body>
</html>
