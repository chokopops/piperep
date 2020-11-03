
<%@page import="model.User"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Friend" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>

<%
    User myUser = (User)request.getAttribute("keyUser");

    //String l1 = myUser.getLogin();
    //String pwd1 = myUser.getPwd();

%>

    <table>
        <tr>
            <td> First Name</td>
            <td> Last Name</td>
        </tr>

        <c:forEach items="${keyListOfFriends}" var="aFriend">
            <tr>
                <td>${aFriend.firstName}</td>
                <td>${aFriend.lastName}</td>
            </tr>
        </c:forEach>

    </table>


</body>
</html>
