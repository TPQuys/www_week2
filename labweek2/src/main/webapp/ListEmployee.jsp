<%@ page import="vn.edu.iuh.fit.services.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/23/2023
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
<%
    EmployeeService employeeServices = new EmployeeService();
%>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>DOB</th>
        <th>PHONE</th>
        <th>ADDRESS</th>
        <th>EMAIL</th>
        <th>STATUS</th>
        <th>Orders</th>
        <th><a href="InsertEmployee.jsp">INSERT</a></th>

    </tr>
    <%
         List<Employee> employees = employeeServices.findAll();
         for (Employee employee : employees){
    %>
    <tr>
        <td><%=employee.getEmployeeId()%>
        </td>
        <td><%=employee.getFullName()%>
        </td>
        <td><%=employee.getDob()%>
        </td>
        <td><%=employee.getPhone()%>
        </td>
        <td><%=employee.getAddress()%>
        </td>
        <td><%=employee.getEmail()%>
        </td>
        <td><%=employee.getStatus()%>
        </td>
        <% request.setAttribute("id",employee.getEmployeeId());%>
        <td>
            <a href="EmployeeByOrder.jsp?idEmployee=<%=employee.getEmployeeId()%>">Xem order</a>
        </td>
    </tr>
    <%}
    %>
</table>
</body>
</html>
