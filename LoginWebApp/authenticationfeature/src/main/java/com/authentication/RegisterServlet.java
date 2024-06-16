package com.authentication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String message = null;
        System.out.println(userName);
        try {
            message = ORM.createUser(userName, password);
            session.setAttribute("message", message);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (message != null) {
            session.setAttribute("message", message);

        } else {
            message = "Something went wrong while registering ";
            session.setAttribute("message", message);
        }
        req.getRequestDispatcher("register.jsp").forward(req, res);
    }

}
