package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @OneToOne
    @JoinColumn (name = "order_id")
    private Order id;

    @OneToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;

    public OrderDetail( Product product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail() {

    }

    public Order getId() {
        return id;
    }

    public void setId(Order id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
