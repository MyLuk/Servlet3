<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 22.11.18
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.myluk.hibernate.entity.Files"%>
<html>
<head>
    <title>Listing images</title>
</head>
<body>
listing images

<%@ page import="java.util.List" %><%
    String path = (String) request.getAttribute("path");
    List<Files> files = (List<Files>) request.getAttribute("files");
    for (Files file: files
         ) {
        out.print(file.getFilename());
        out.println("<br/><img src="+path+file.getFilename()+">");
    }

%>
</body>
</html>
