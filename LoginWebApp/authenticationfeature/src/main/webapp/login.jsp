<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <link rel="stylesheet" href="./styles/Register.css" />
  <body>

    <div class="container">
      <h1>Welcome to login page!!</h1>
      <form id="registrationForm" action='login' method = 'post'  onsubmit="return submitForm()">
        <div class="form-inputs">
          <label for="username">Username:</label>
          <input type="text" id="username" name="username" required />
        </div>

        <div class="form-inputs">
          <label for="password">Password:</label>
          <input type="password" id="password" name="password" required />
        </div>
        
        <input type="submit" value="Login" />

    </form>

    <% 
        String message = (String) session.getAttribute("loginMessage");
        if (message != null) {
    
    %>
            <p style="color:red;"><%= message %></p>
    <%             
        }
    %>

    </div>
  </body>
</html>
