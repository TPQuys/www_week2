package vn.edu.iuh.fit.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.controllers.EmployeeModel;
import vn.edu.iuh.fit.enums.EnumEmployee;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.models.Order;

import java.time.LocalDate;
import java.util.List;

public class EmployeeReponsitory {
    private EntityManager em;
    private EntityTransaction trans;

    public EmployeeReponsitory(){
        em = Persistence
                .createEntityManagerFactory("labweek2")
                .createEntityManager();
        trans = em.getTransaction();
    }

    public void insertEmp(Employee e){
        try{
            trans.begin();
            em.persist(e);
            trans.commit();
        }catch (Exception e1){e1.printStackTrace();}
    }

    public Employee findById(long id) {
        trans.begin();
        return em.find(Employee.class, id);
    }

    public void deleteEmp(long id){
        try {
            trans.begin();
            Employee emp = em.find(Employee.class, id);
            emp.setStatus(EnumEmployee.FIRED);
            em.merge(emp);
            trans.commit();
        }catch (Exception e){e.printStackTrace();}
    }
    public List<Employee> findAll(){
        Query query = em.createQuery("select e from Employee e");
        return query.getResultList();
    }

}
