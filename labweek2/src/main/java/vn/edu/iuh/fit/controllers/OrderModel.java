package vn.edu.iuh.fit.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.services.OrderService;

import java.time.LocalDate;
import java.util.List;

public class OrderModel {
    private OrderService orderService;

    public OrderModel(){
        orderService = new OrderService();
    }
    public LocalDate findOrders(HttpServletRequest req, HttpServletResponse resp){
        return LocalDate.parse(req.getParameter("date1"));
    }
}
