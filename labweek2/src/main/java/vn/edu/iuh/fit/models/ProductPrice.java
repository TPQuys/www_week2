package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.util.Date;
@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product id;
    @Column(name = "price_date_time",nullable = false)
    private Date priceDateTime;
    @Column(nullable = false)
    private double piece;
    @Column(length = 300)
    private String note;

    public ProductPrice(Product id, Date priceDateTime, double piece, String note) {
        this.id = id;
        this.priceDateTime = priceDateTime;
        this.piece = piece;
        this.note = note;
    }

    public ProductPrice() {

    }

    public Product getId() {
        return id;
    }

    public void setId(Product id) {
        this.id = id;
    }

    public Date getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(Date priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public double getPiece() {
        return piece;
    }

    public void setPiece(double piece) {
        this.piece = piece;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
