<%@ page import="vn.edu.iuh.fit.models.Employee" %>
<%@ page import="vn.edu.iuh.fit.services.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="vn.edu.iuh.fit.models.Order" %>
<%@ page import="vn.edu.iuh.fit.services.OrderService" %><%--
  Created by IntelliJ IDEA.
  User: Trinh Quy
  Date: 11/8/2023
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>orders</title>
</head>
<body>
<%
    String idT= request.getParameter("idEmployee");
%>
<form method="post">
    Id nhân viên <input name="id" value="<%=idT!=null?idT:""%>" readonly required>
    Từ ngày: <input name="from" type="Date" required>
    Đến ngày: <input name="to" type="Date" required>
    <button type="submit">tim</button>
</form>
<% OrderService orderService = new OrderService();%>
        <table>
    <%
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String idF = request.getParameter("id");
        if(from != null && to != null) {
            LocalDate f = LocalDate.parse(from);
            LocalDate t = LocalDate.parse(to);
            long idE = Long.parseLong(idF);
            List<Order> orders = orderService.OrderByEmployee(f,t,idE);
            for ( Order o : orders){
    %>
            <tr>
                <td>Id</td>
                <td>Employee</td>
                <td>Date</td>
            </tr>
            <tr>
                <td> <%=o.getId()%></td>
                <td><%=o.getEmpId().getEmployeeId()%></td>
                <td><%=o.getDate()%></td>
            </tr>
    <%}}
    %>
</table>
</body>
</html>
