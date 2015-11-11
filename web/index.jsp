<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: andriell
  Date: 09.11.15
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
test<%= new Date() %>
  <% for(int i = 0; i < 10; i++) { %>
    <p>
      <%= i %>
    </p>
  <% } %>
  </body>
</html>
