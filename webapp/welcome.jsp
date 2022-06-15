<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  </head>

  <body>
    <jsp:include page="menu.jsp"></jsp:include>

    <div class="p-5 bg-primary text-white">
      <div class="container">
        <h1 class="display-3">
          Welcome to Web Shopping Mall
        </h1>
      </div>
    </div>

    <div class="container">
      <div class="text-center">
        <h3>Welcome to Web Market!</h3>
        <%
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
        %>
        현재 접속 시각: <%= format.format(now) %>
      </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

  </body>

  </html>