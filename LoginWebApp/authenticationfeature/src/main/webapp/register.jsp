<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <body>
  <h1>Welcome to registration page!!</h1>
    <form action = "register" method="post">
    Enter username: <input type = "text" name = "username">
    <br>
    Enter password: <input type = "text" name = "password">
    <br>
    <input type="submit" value="register">

   <% 
        String message = (String) session.getAttribute("message");
        if (message != null) {
            if ("User registered successfully".equals(message)) {
    %>
                <p style="color:green;">
                <%= message %>
                <a href = "login.jsp">Click here to login</a>
                </p>
    <% 
            } else {
    %>
                <p style="color:red;"><%= message %></p>
    <% 
            }
        }
    %>
    </form> 
  </body>
</html>
