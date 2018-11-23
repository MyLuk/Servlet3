<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 21.11.18
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image Upload</title>
</head>
<body>
<form action="ImageUploadDemoServlet?action=filesUpload" method="post" enctype="multipart/form-data">
    Select images: <input type="file" name="files" multiple/>
    <input type="submit" value="Upload">
    <br>
    <a href="${pageContext.request.contextPath}/ImageUploadDemoServlet?action=listingImages">View available images</a>
</form>
</body>
</html>
