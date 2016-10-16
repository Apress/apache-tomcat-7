<%@page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
   <title>Apress Demo</title>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <div class="content">
      Chinese: <b>你好.你好吗</b> <br/><br/>
      German: <b>Victor jagt zwölf Boxkämpfer quer über den Sylter Deich${sessionScope.org.apache.catalina.filters.CSRF_NONCE}</b>
        <%
            String url = response.encodeURL("/secure/showAccount.jsp");
        %>
        <a href="<%=url%>">Show Account</a>
        <form action="<%=url%>" method="POST">
            <input type="submit" name="submit post request" value="submit post request" />
        </form>

    </div>
  </body>
</html>
