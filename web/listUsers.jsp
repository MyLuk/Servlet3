<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<%@ include file="/include/header.jsp"%>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="org.myluk.entity.User" %>--%>

<%--&lt;%&ndash;<c:import url="include/header.jsp"><c:param name="title" value="List Users"/></c:import>&ndash;%&gt;--%>
<%--<div class="container mtb">--%>
    <%--<div class="row">--%>
        <%--<div class="col-lg-6">--%>
            <%--<strong>List users</strong>--%>
            <%--<hr/>--%>
            <%--<table border="1">--%>
                <%--<thead>--%>
                <%--<th>User ID</th>--%>
                <%--<th>Username</th>--%>
                <%--<th>Email</th>--%>
                <%--<th>Operation</th>--%>
                <%--</thead>--%>
                <%--<c:forEach items="${listUsers}" var="user">--%>
                    <%--<c:url var="updateURL" value="operation">--%>
                        <%--<c:param name="page" value="updateUser"/>--%>
                        <%--<c:param name="usersId" value="${user.users_id}"/>--%>
                        <%--<c:param name="username" value="${user.username}"/>--%>
                        <%--<c:param name="email" value="${user.email}"/>--%>
                    <%--</c:url>--%>
                    <%--<c:url var="deleteUser" value="operation">--%>
                        <%--<c:param name="page" value="deleteUser"/>--%>
                        <%--<c:param name="usersId" value="${user.users_id}"/>--%>
                    <%--</c:url>--%>

                    <%--<tr>--%>
                        <%--<td>${user.users_id}</td>--%>
                        <%--<td>${user.username}</td>--%>
                        <%--<td>${user.email}</td>--%>
                        <%--<td>--%>
                            <%--<a href="${updateURL}">Update</a>|--%>
                            <%--<a href="${deleteUser}"--%>
                               <%--onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete--%>
                            <%--</a>--%>
                        <%--</td>--%>

                    <%--</tr>--%>
                <%--</c:forEach>--%>



                <%--&lt;%&ndash;<%!String deleteURL;%>&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;%>--%>
                    <%--&lt;%&ndash;List<User> listUsers = (List) request.getAttribute("listUsers");&ndash;%&gt;--%>
                    <%--&lt;%&ndash;String updateURL;&ndash;%&gt;--%>
                    <%--&lt;%&ndash;for (int i = 0; i < listUsers.size(); i++) {&ndash;%&gt;--%>
                        <%--&lt;%&ndash;out.print("<tr>");&ndash;%&gt;--%>
                        <%--&lt;%&ndash;out.print("<td>" + listUsers.get(i).getUsers_id() + "</td>");&ndash;%&gt;--%>
                        <%--&lt;%&ndash;out.print("<td>" + listUsers.get(i).getUsername() + "</td>");&ndash;%&gt;--%>
                        <%--&lt;%&ndash;out.print("<td>" + listUsers.get(i).getEmail() + "</td>");&ndash;%&gt;--%>
                        <%--&lt;%&ndash;updateURL = request.getContextPath() + "/operation?page=updateUser" + "&usersId="&ndash;%&gt;--%>
                                <%--&lt;%&ndash;+ listUsers.get(i).getUsers_id() + "&username=" + listUsers.get(i).getUsername() + "&email="&ndash;%&gt;--%>
                                <%--&lt;%&ndash;+ listUsers.get(i).getEmail();&ndash;%&gt;--%>
                        <%--&lt;%&ndash;deleteURL = request.getContextPath() + "/operation?page=deleteUser" + "&usersId="&ndash;%&gt;--%>
                                <%--&lt;%&ndash;+ listUsers.get(i).getUsers_id();&ndash;%&gt;--%>
                        <%--&lt;%&ndash;out.print("<td><a href=" + updateURL + ">Update</a>|");&ndash;%&gt;--%>
                <%--&lt;%&ndash;%>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<a href="<%=deleteURL%>"&ndash;%&gt;--%>
                   <%--&lt;%&ndash;onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;%>--%>
                    <%--&lt;%&ndash;}&ndash;%&gt;--%>
                <%--&lt;%&ndash;%>&ndash;%&gt;--%>
            <%--</table>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--&lt;%&ndash;<c:import url="include/footer.jsp"/>&ndash;%&gt;--%>
<%--<%@ include file="/include/footer.jsp"%>--%>