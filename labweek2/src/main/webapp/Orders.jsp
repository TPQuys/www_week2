<%@ page import="vn.edu.iuh.fit.services.OrderService" %>
<%@ page import="vn.edu.iuh.fit.models.Order" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.controllers.OrderModel" %><%--
  Created by IntelliJ IDEA.
  User: Trinh Quy
  Date: 10/24/2023
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<% OrderService orderService = new OrderService();
%>
    <form  method="post">
        <label>
<%--            <select name="date1">--%>
<%--                <option value="2002-10-20">2002-10-20</option>--%>
<%--                <option value="2002-10-21">2002-10-21</option>--%>
<%--            </select>--%>
            <input type="date" name="date1">
        </label>
        <button type="submit">Thong ke</button>
    </form>
<table>
    <%
        String req = request.getParameter("date1");
        if(req != null) {
            LocalDate date = LocalDate.parse(req);
            List<Order> orders = orderService.getOrderByDate(date);
   for ( Order o : orders){
    %> <tr>
    <td>Id</td>
    <td>Employee</td>
    <td>Date</td>
</tr>
    <tr>
        <td> <%=o.getId()%></td>
        <td><%=o.getEmpId().getEmployeeId()%></td>
        <td><%=o.getDate()%></td>
    </tr>
    <%}}%>
</table>
</body>
</html>
