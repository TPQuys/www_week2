package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.enums.EnumEmployee;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.resources.EmployeeResources;
import vn.edu.iuh.fit.services.EmployeeService;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

@WebServlet("/controls")
public class ServletController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actionObject = req.getParameter("action");
        if(actionObject!=null){
            String action = actionObject.toString();
            if(action.equals("insertEmp")){
                EmployeeModel employeeModel = new EmployeeModel();
                try {
                    employeeModel.insertEmp(req, resp);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (action.equals("ListEmployees")){
                resp.sendRedirect("ListEmployee.jsp");
            }else if (action.equals("findOrder")){
                req.getParameter("date1");
            }else if (action.equals("Delete")){
                EmployeeService es = new EmployeeService();
                long id=Long.parseLong( req.getParameter("id"));
                es.deleteEmp(id);
                resp.sendRedirect("ListEmployee.jsp");
            }
        }
        else {
            resp.sendRedirect("../webapp/index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
