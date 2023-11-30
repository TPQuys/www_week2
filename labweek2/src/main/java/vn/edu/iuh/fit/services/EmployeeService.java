package vn.edu.iuh.fit.services;

import jakarta.ws.rs.Path;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.reponsitories.EmployeeReponsitory;

import java.util.List;

public class EmployeeService {
    private EmployeeReponsitory reponsitory;

    public EmployeeService(){
        reponsitory= new EmployeeReponsitory();
    }

    public void insertEmp(Employee e){
        reponsitory.insertEmp(e);
    }

    public Employee getEmployeeById( long id) {
        return reponsitory.findById(id);
    }

    public void deleteEmp(long id){
        reponsitory.deleteEmp(id);
    }
    public List<Employee> findAll(){
        return reponsitory.findAll();
    }
}
