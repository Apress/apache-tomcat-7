<html>
  <head>
   <title>Apress Demo</title>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <div class="content">
      <b>Welcome to Apress,  <%= request.getRemoteUser() %> <br/>

          SSL Session ID: <%= request.getAttribute("javax.servlet.request.ssl_session") %>
       </b>
    </div>
  </body>
</html>
