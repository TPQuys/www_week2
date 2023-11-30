package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "orders")
@NamedQueries(
        @NamedQuery(name = "Order.findAll", query = "select  o from Order o")
)
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "order_date",nullable = false)
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee empId;

    public Order() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Employee getEmpId() {
        return empId;
    }

    public void setEmpId(Employee empId) {
        this.empId = empId;
    }

    public Order(long id, LocalDate date, Employee empId) {
        this.id = id;
        this.date = date;
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", empId=" + empId +
                '}';
    }
}
