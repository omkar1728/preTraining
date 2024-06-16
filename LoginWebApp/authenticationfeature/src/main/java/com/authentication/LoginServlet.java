package com.authentication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String loginMessage = null;
        HttpSession session = req.getSession();
        User user = null;
        try {
            user = ORM.getUser(userName);
        } catch (Exception e) {
            loginMessage = "Something went wrong";
            session.setAttribute("loginMessage", loginMessage);
            // res.sendRedirect("login.jsp");
        }
        if (user == null) {
            loginMessage = "Something went wrong";
            session.setAttribute("loginMessage", loginMessage);
            res.sendRedirect("login.jsp");

        } else {
            if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
                session.setAttribute("username", userName);
                res.sendRedirect("welcome.jsp");
            } else {
                loginMessage = "Credentials wrong. Kindly re-check username and password";
                session.setAttribute("loginMessage", loginMessage);
                res.sendRedirect("login.jsp");
            }

        }

    }

}
