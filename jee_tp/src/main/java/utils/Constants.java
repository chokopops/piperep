package utils;

import model.Friend;

import java.sql.Connection;
import java.util.ArrayList;

public class Constants {

    public static final String GOOD_LOGIN = "validlogin";
    public static final String GOOD_PWD = "validpwd";
    public static final String LOGIN_PAGE = "/WEB-INF/jsp/index.jsp";

    public static final String JDBC_DRIVER = "org.h2.Driver";

    public static  ArrayList<Friend> listOfFriends = new ArrayList<>();
    public static  Connection conn = null;
}
