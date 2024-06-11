<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <body>
  <h1>Welcome to login page!!</h1>
    <form action = "login" method="post">
    Enter username: <input type = "text" name = "username">
    <br>
    Enter password: <input type = "text" name = "password">
    <br>
    <input type="submit" value="login">
    </form> 
    <br>
    <% 
        String message = (String) session.getAttribute("message");
        if (message != null) {
    
    %>
            <p style="color:red;"><%= message %></p>
    <%             
        }
    %>
  </body>
</html>
