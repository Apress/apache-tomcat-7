<%@ page import="java.util.Calendar" %>

<html>
<head>
    <title>Apress Demo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <div class="content">
        <b>Welcome to Apress</b>

        <p>Today is <%=Calendar.getInstance().getTime()%>>
        </p>
        <%
            String greeting;
            int hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            if (hourOfDay < 12) {
                greeting = "Good Morning!";
            } else if (hourOfDay >= 12 && hourOfDay < 19) {
                greeting = "Good Afternoon!";
            } else {
                greeting = "Good Evening!";
            }

        %>
        <p><%=greeting%></p>
    </div>
</body>
</html>