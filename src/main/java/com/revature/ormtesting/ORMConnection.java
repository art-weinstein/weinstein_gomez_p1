package com.revature.ormtesting;

import com.revature.util.JDBCConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ORMConnection {

    private static Connection conn = null;

    public static Connection getConnection() {

        /*
        To establish a new connection if one doesn't exist,
        otherwise return the current connection.
        Credentials: url (endpoint), username, password
         */

        if (conn == null) {
            //Establish a new Connection

            Properties props = new Properties();
            try {

                Class.forName("org.postgresql.Driver");

                props.load(JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties"));
//                props.load(new FileInputStream(JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile()));
//                props.load(new FileReader("src/main/resources/connection.properties"));

                String endpoint = props.getProperty("endpoint");
                //URL Format (Postgresql JDBC)
                //jdbc:postgresql://[endpoint]/[database]
                String url = "jdbc:postgresql://" + endpoint + "/postgres";
                String username = props.getProperty("username");
                String password = props.getProperty("password");

                conn = DriverManager.getConnection(url, username, password);

            } catch (IOException | SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

}