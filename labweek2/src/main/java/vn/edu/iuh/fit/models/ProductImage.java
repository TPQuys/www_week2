package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @OneToOne()
    @JoinColumn(name = "product_id")
    private Product id;
    @Column(name = "image_id",nullable = false)
    private long imageId;
    @Column(length = 250,nullable = false)
    private String path;
    private String alternative;

    public ProductImage(long imageId, String path, String alternative) {
        this.imageId = imageId;
        this.path = path;
        this.alternative = alternative;
    }

    public ProductImage() {

    }

    public Product getId() {
        return id;
    }

    public void setId(Product id) {
        this.id = id;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }
}
