package com.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("welcome doget getting called");
        System.out.println(session.getAttribute("username"));
        if (session.getAttribute("username") == null) {
            System.out.println("username found null");
            res.sendRedirect("login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("welcome post getting hit");
        session.removeAttribute("username");
        session.invalidate();
        res.sendRedirect("login.jsp");
    }
}