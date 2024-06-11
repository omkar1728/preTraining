<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <body>
    <%
      response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //for http 1.1
      response.setHeader("Pragma", "no-cache"); //for http 1.0
      response.setHeader("Expires", "0"); //for proxies
      if(session.getAttribute("username") == null){
        response.sendRedirect("login.jsp");
      }

    %>

    Hi ${username}!! You are logged in!!
      <br />
    <form action="welcome" method="post">
      <br />
      <input type="submit" name="logout" value="Logout" />
    </form>
  </body>
</html>
