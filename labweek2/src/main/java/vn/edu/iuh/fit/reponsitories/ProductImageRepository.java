package vn.edu.iuh.fit.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.models.ProductImage;

import java.util.List;
import java.util.Optional;

public class ProductImageRepository {
    private EntityManager em ;
    private EntityTransaction trans;
    public ProductImageRepository(){
        em =Persistence.createEntityManagerFactory("labweek2").createEntityManager();
        trans = em.getTransaction();
    }

    public void insert(ProductImage p){
        try
        {
            trans.begin();
            em.persist(p);
            trans.commit();
        }catch (Exception e){e.printStackTrace();}
    }
    public void deleteProduct(long id){
        try
        { trans.begin();
            ProductImage p = em.find(ProductImage.class,id);
            em.remove(p);
            trans.commit();}catch (Exception e){e.printStackTrace();}
    }
    public Optional<ProductImage> findById(long id){
        ProductImage p =em.find(ProductImage.class,id);
        return Optional.ofNullable(p);
    }
    public List<ProductImage> findAll(){
        Query query = em.createQuery("select p from ProductImage p ");
        return query.getResultList();
    }
}
