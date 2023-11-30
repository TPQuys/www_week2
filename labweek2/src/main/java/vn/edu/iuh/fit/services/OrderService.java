package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.reponsitories.OrderReponsitory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class OrderService {
    private OrderReponsitory reponsitory;

    public OrderService(){
        reponsitory= new OrderReponsitory();
    }

    public void insertOrder(Order e){
        reponsitory.insertOrder(e);
    }

    public Order getOrderById( long id) {
        return reponsitory.findById(id);
    }

    public void updateOrder(Order o, LocalDate date){
        reponsitory.updateOrder(o,date);
    }

    public LocalDate getDate(String date) {
        return LocalDate.parse(date);
    }

    public List<Order> getOrderByDate(LocalDate date){
        return reponsitory.getOrdersByDate(date);
    }
    public List<Order> OrderByEmployee(LocalDate f, LocalDate t,long id){
        return reponsitory.OderByEmployee(f,t,id);
    }
}
