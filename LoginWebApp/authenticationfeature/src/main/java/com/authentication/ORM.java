package com.authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ORM {
    private static String url = "jdbc:mysql://localhost:3306/experimental";
    private static String sqlUserName = "myuser";
    private static String sqlPassword = "mypassword";

    public static String createUser(String userName, String password) throws SQLException {
        int resultSet = 2;
        String query = String.format("INSERT INTO `users` (`username`, `password`) VALUES ('%s', '%s');", userName,
                password);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = DriverManager.getConnection(url, sqlUserName, sqlPassword);
        Statement statement = con.createStatement();
        try {
            resultSet = statement.executeUpdate(query);

        } catch (SQLException e) {
            if (e.getSQLState().equals("23000")) { // SQL state for integrity constraint violation
                System.out.println("Duplicate key error: " + e.getMessage());
                return "username already take choose a different one";
            } else {
                e.printStackTrace();
            }
        }

        if (resultSet == 1) {
            System.out.println("user inserted success from orm");
            return "User registered successfully";
        }

        con.close();
        return "";

    }

    // gets user object
    public static User getUser(String userName) throws Exception {
        String query = String.format("SELECT * FROM users WHERE username = '%s'", userName);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = DriverManager.getConnection(url, sqlUserName, sqlPassword);
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        String password = null;
        while (resultSet.next()) {
            userName = resultSet.getString(1);
            password = resultSet.getString(2);
        }

        con.close();
        if (password == null) {
            throw new Exception("Something went wrong");
        }
        User user = new User(userName, password);
        return user;

    }
}

class User {
    private String userName;
    private String password;

    User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }
}