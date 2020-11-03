package ctrl;

import model.Friend;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import static utils.Constants.*;

public class DataServices {

    private ArrayList<Friend> listOfFriends;


    public static ArrayList<Friend>  getFriends(ArrayList<Friend> listOfFriends, Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  * From FRIENDS");
            listOfFriends = new ArrayList<>();
            while (rs.next()) {
                Friend aFriend = new Friend();
                aFriend.setFirstName(rs.getString("FIRSTNAME"));
                aFriend.setLastName(rs.getString("NAME"));
                listOfFriends.add(aFriend);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return listOfFriends;
    }

    public static Connection connect(Connection conn){

        try {
            Class.forName(JDBC_DRIVER);

            InputStream input = new FileInputStream("C:\\Users\\panin\\IdeaProjects\\jee_tp\\src\\main\\webapp\\WEB-INF\\db.properties");

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            String dburl = prop.getProperty("dburl");
            String dblogin = prop.getProperty("dblogin");
            String dbpwd = prop.getProperty("dbpwd");

            conn = DriverManager.getConnection(dburl, dblogin, dbpwd);


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

}
