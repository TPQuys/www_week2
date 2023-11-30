<%--
  Created by IntelliJ IDEA.
  User: Trinh Quy
  Date: 9/28/2023
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InsertEmployee</title>
    <style>
        h1{
            text-align: center;
        }
        form{
            width: 300px;
            border: solid ;
            padding: 20px;
            margin: auto;
        }
        input,textarea{
            display: block;
            width: 100%;
        }
        input.b{
            display: inline;
            width: 49%;
        }
    </style>
</head>
<body>
<h1>INSERT NEW EMPLOYEE</h1>
<form action="controls?action=insertEmp" method="post">
    Full Name: <input type="text" name="fullname"/><br/>
    Date of birth: <input type="date" name="dob"/><br/>
    Email: <input type="text" name="email"><br/>
    Phone: <input name="phone"><br/>
    Address: <textarea name="address"  cols="30" rows="3"></textarea>
    <input class="b" type="submit" value="insert"/>
    <input class="b" type="reset" value="clear"/>
</form>
</body>
</html>

