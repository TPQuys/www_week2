package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.EnumProduct;
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;
    @Column(nullable = false,length = 150)
    private String name;
    @Column(length = 500)
    private String description;
    @Column(length = 50,nullable = false)
    private String unit;
    @Column(name = "manufacturer_name",nullable = false,length = 100)
    private String manufacturerName;
    @Enumerated(EnumType.ORDINAL)
    private EnumProduct status;


    public Product(String name, String description, String unit, String manufacturerName, EnumProduct status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
    }

    public Product() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public EnumProduct getStatus() {
        return status;
    }

    public void setStatus(EnumProduct status) {
        this.status = status;
    }
}
