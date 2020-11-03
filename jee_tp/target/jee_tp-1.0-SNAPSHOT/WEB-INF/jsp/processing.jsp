
<%@page import="model.User"%>
<%

    User myUser = new User();

    String login = request.getParameter("loginForm");
    String pwd = request.getParameter("passForm");

    myUser.setLogin(login);
    myUser.setPwd(pwd);

    request.setAttribute("keyUser",myUser);
    request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);

%>